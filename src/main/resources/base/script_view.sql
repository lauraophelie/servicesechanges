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
    mot_passe
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