-------------------------- 29/04/2025 -------------------------

CREATE OR REPLACE VIEW v_utilisateur AS
SELECT
    id,
    CONCAT(prenom, ' ', nom) AS nom_complet,
    (EXTRACT(YEAR FROM now()) - EXTRACT(YEAR FROM date_naissance)) as age,
    CASE
        WHEN genre = 0 THEN 'Homme'
        WHEN genre = 1 THEN 'Femme'
    END AS genre,
    nom,
    prenom,
    email,
    contact,
    mot_passe,
    date_naissance
FROM utilisateur;

-------------------------- 30/04/2025 ---------------------------

CREATE OR REPLACE VIEW v_pre_tri_data_reponse_candidat AS
SELECT 
    r.*,
    (EXTRACT(DAY FROM r.date_disponibilite) - EXTRACT(DAY FROM d.date_besoin_service)) AS ecart_jour,
    ABS(r.prix_propose - d.prix) AS ecart_prix,
    p.date_limite_reponse,
    p.marge_disponibilite,
    p.min_prix_propose,
    p.max_prix_propose
FROM reponse_service AS r
JOIN demande_service AS d ON r.id_demande_service = d.id
JOIN parametrage_demande_service AS p ON r.id_demande_service = p.id_demande_service;

CREATE OR REPLACE VIEW v_tri_data_reponse_candidat AS
SELECT
    t.id,
    t.id_demande_service AS id_demande,
    t.prix_propose,
    t.date_disponibilite,
    t.id_utilisateur AS id_candidat,
    t.ecart_jour
FROM v_pre_tri_data_reponse_candidat AS t
WHERE (
    t.date_reponse <= t.date_limite_reponse
    AND
    t.ecart_jour <= t.marge_disponibilite 
    AND 
    t.prix_propose BETWEEN t.min_prix_propose AND t.max_prix_propose
);

CREATE OR REPLACE VIEW v_data_reponse_candidat AS
SELECT
    id AS id_reponse,
    id_candidat,
    'prix' AS critere,
    prix_propose,
    NULL AS date_disponibilite,
    id_demande,
    NULL AS ecart_jour
FROM v_tri_data_reponse_candidat
UNION ALL
SELECT
    id AS id_reponse,
    id_candidat,
    'disponibilité' AS critere,
    NULL As prix_propose,
    date_disponibilite,
    id_demande,
    ecart_jour
FROM v_tri_data_reponse_candidat;

CREATE OR REPLACE VIEW v_reponse_candidat AS
SELECT
    d.*,
    c.id AS id_critere
FROM v_data_reponse_candidat AS d
JOIN critere AS c ON d.critere = LOWER(c.designation_critere);

CREATE OR REPLACE VIEW v_reponse_candidat_a_penalite AS
SELECT
    r.*,
    p.valeur_penalite AS penalite
FROM v_reponse_candidat AS r
LEFT JOIN parametrage_penalite_jour AS p 
ON r.ecart_jour BETWEEN p.valeur_min AND p.valeur_max;

CREATE OR REPLACE VIEW v_score_partiel_reponse AS
SELECT
    r.id_reponse,
    r.id_candidat,
    r.id_demande,
    r.id_critere,
    r.critere,
    r.prix_propose,
    r.ecart_jour,
    (10 - (r.prix_propose / d.prix * 10)) AS score_partiel_prix,
    (10 - (ABS(r.ecart_jour) * r.penalite)) AS score_partiel_disponibilite
FROM v_reponse_candidat_a_penalite AS r
JOIN demande_service AS d ON r.id_demande = d.id;

CREATE OR REPLACE VIEW v_score_reponse AS
SELECT
    sp.id_reponse,
    sp.id_candidat,
    sp.id_demande,
    sp.id_critere,
    sp.critere,
    sp.score_partiel_prix,
    sp.score_partiel_disponibilite,
    (sp.score_partiel_prix + n.bonus - n.malus) AS score_prix,
    (sp.score_partiel_disponibilite + n.bonus - n.malus) AS score_disponibilite
FROM v_score_partiel_reponse AS sp
JOIN attribution_note_critere AS n
ON (
    sp.prix_propose >= n.min AND sp.prix_propose < n.max
    OR 
    sp.ecart_jour >= n.min AND sp.ecart_jour < n.max
);

CREATE OR REPLACE VIEW v_note_reponse_critere AS
SELECT
    s.*,
    p.poids,
    ((s.score_prix * p.poids) / 100) AS note_prix,
    ((s.score_disponibilite * p.poids) / 100) AS note_disponibilite
FROM v_score_reponse AS s
JOIN attribution_poids_critere AS p ON s.id_critere = p.id_critere;


CREATE OR REPLACE VIEW v_note_finale_reponse_candidat AS
SELECT
    id_reponse,
    id_demande,
    id_candidat,
    MAX(CASE WHEN critere = 'prix' THEN note_prix ELSE NULL END) AS note_prix,
    MAX(CASE WHEN critere = 'disponibilité' THEN note_disponibilite ELSE NULL END) AS note_disponibilite,
    (
        COALESCE(MAX(CASE WHEN critere = 'prix' THEN note_prix ELSE NULL END), 0) + 
        COALESCE(MAX(CASE WHEN critere = 'disponibilité' THEN note_disponibilite ELSE NULL END), 0)
    ) AS note_finale
FROM v_note_reponse_critere
GROUP BY id_reponse, id_demande, id_candidat;


CREATE OR REPLACE FUNCTION get_classement_demande(p_id_demande INT)
RETURNS TABLE (
    classement BIGINT,
    id_reponse INT,
    id_candidat INT,
    candidat TEXT,
    note_prix NUMERIC,
    note_disponibilite NUMERIC,
    note_finale NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
        SELECT 
            RANK() OVER (ORDER BY v.note_finale DESC)::BIGINT AS classement,
            v.id_reponse,
            v.id_candidat,
            u.nom_complet AS candidat,
            v.note_prix,
            v.note_disponibilite,
            v.note_finale
        FROM v_note_finale_reponse_candidat AS v
        JOIN v_utilisateur AS u ON v.id_candidat = u.id
        WHERE v.id_demande = p_id_demande
        ORDER BY classement;
END;
$$;