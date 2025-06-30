------------------------------ 29/04/2025 -------------------------------

INSERT INTO utilisateur(nom, prenom, date_naissance, genre, email, contact, mot_passe) VALUES
    ('RASOA', 'Annie', '2002-01-02', 1, 'annierasoa@gmail.com', '0321456987', '01234'),
    ('ANDRY', 'Anna', '2000-04-15', 1, 'anna@gmail.com', '0325287941', '1234'),
    ('RASOA', 'John', '2001-06-12', 0, 'johnrasoa@gmail.com', '332165498', '1234');

INSERT INTO demande_service(intitule_service, description_service, date_besoin_service, prix, id_utilisateur) VALUES
    ('Besoin de nettoyage', 'Nettoyage de plusieurs voiture', '2025-05-04', 250000, 1);

INSERT INTO reponse_service(prix_propose, date_disponibilite, id_utilisateur, id_demande_service) VALUES
    (150000, '2025-05-05', 2, 1),
    (300000, '2025-05-02', 3, 1);

INSERT INTO parametrage_demande_service(id_demande_service, date_limite_reponse, marge_disponibilite, min_prix_propose, max_prix_propose) VALUES
    (1, '2025-05-03', 2, 200000, 350000);

INSERT INTO critere(designation_critere) VALUES
    ('Prix'),
    ('Disponibilité');

INSERT INTO attribution_note_critere(id_demande_service, id_critere, min, max, bonus, malus) VALUES
    (1, 1, 100000, 150000, 1, 0),
    (1, 1, 150000, 175000, 1, 0),
    (1, 1, 175000, 200000, 0, 0),
    (1, 1, 200000, 250000, 0, 0),
    (1, 1, 250000, 300000, 0, 0),
    (1, 1, 300000, 350000, 0, 2),
    (1, 2, -5, 1, 0, 0),
    (1, 2, 1, 3, 0, 0);

INSERT INTO attribution_poids_critere(id_demande_service, id_critere, poids) VALUES
    (1, 1, 40),
    (1, 2, 60);


------------------------ 01/05/2025 ------------------------------

INSERT INTO parametrage_penalite_jour(valeur_min, valeur_max, valeur_penalite) VALUES
    (-3, -1, 2),
    (-1, 1, 1),
    (1, 3, 2),
    (3, 6, 3);

--------------------------- 30/06/2025 -----------------------------------

INSERT INTO demande_service(intitule_service, description_service, date_besoin_service, prix, id_utilisateur) VALUES
    ('Besoin de nettoyage', 'Nettoyage de plusieurs voiture', '2025-07-04', 250000, 1);


INSERT INTO reponse_service(prix_propose, date_disponibilite, id_utilisateur, id_demande_service) VALUES
    (175000, '2025-07-01', 2, 2),
    (300000, '2025-07-02', 3, 2);

INSERT INTO parametrage_demande_service(id_demande_service, date_limite_reponse, marge_disponibilite, min_prix_propose, max_prix_propose) VALUES
    (2, '2025-07-02', 2, 250000, 350000);

INSERT INTO critere(designation_critere) VALUES
    ('Prix'),
    ('Disponibilité');

INSERT INTO attribution_note_critere(id_demande_service, id_critere, min, max, bonus, malus) VALUES
    (2, 1, 100000, 150000, 1, 0),
    (2, 1, 150000, 175000, 1, 0),
    (2, 1, 175000, 200000, 0, 0),
    (2, 1, 200000, 250000, 0, 0),
    (2, 1, 250000, 300000, 0, 0),
    (2, 1, 300000, 350000, 0, 2),
    (2, 2, -5, 1, 0, 0),
    (2, 2, 1, 3, 0, 0);

INSERT INTO attribution_poids_critere(id_demande_service, id_critere, poids) VALUES
    (2, 1, 40),
    (2, 2, 60);
