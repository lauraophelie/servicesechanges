CREATE ROLE echange_service LOGIN PASSWORD 'echange';
ALTER USER echange_service WITH SUPERUSER;

CREATE DATABASE echange_service;
ALTER DATABASE echange_service OWNER TO echange_service;

\c echange_service echange_service;

CREATE EXTENSION postgis;
CREATE EXTENSION postgis_topology;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS utilisateur(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250),
    prenom VARCHAR(250),
    date_naissance DATE,
    genre INTEGER CHECK (genre IN (0, 1)),
    email VARCHAR(250),
    contact VARCHAR(10),
    mot_passe VARCHAR(20)
);

---------------------- 28/04/2025 -------------------------------


CREATE TABLE IF NOT EXISTS demande_service(
    id SERIAL PRIMARY KEY,
    date_creation DATE DEFAULT now(),
    description_service TEXT,
    date_besoin_service DATE,
    prix DECIMAL(10, 2) CHECK (prix > 0),
    id_utilisateur INTEGER REFERENCES utilisateur(id)
);

ALTER TABLE demande_service ADD COLUMN intitule_service VARCHAR(250);

CREATE TABLE IF NOT EXISTS reponse_service(
    id SERIAL PRIMARY KEY,
    date_reponse DATE DEFAULT now(),
    prix_propose DECIMAL(10, 2) CHECK (prix_propose > 0),
    date_disponibilite DATE,
    id_utilisateur INTEGER REFERENCES utilisateur(id),
    id_demande_service INTEGER REFERENCES demande_service(id)
);

CREATE TABLE IF NOT EXISTS parametrage_demande_service(
    id SERIAL PRIMARY KEY,
    id_demande_service INTEGER REFERENCES demande_service(id) UNIQUE,
    date_limite_reponse DATE,
    marge_disponibilite INTEGER CHECK (marge_disponibilite > 0),
    min_prix_propose DECIMAL(10, 2) DEFAULT 0 CHECK (min_prix_propose >= 0),
    max_prix_propose DECIMAL(10, 2) CHECK (max_prix_propose >= 0)
);