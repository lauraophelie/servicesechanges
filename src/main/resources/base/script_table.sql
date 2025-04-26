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