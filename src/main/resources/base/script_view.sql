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