package com.echange.servicesechanges.controller;

import java.sql.Date;

public class InscriptionUtilisateur {
    private String nom;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) throws Exception {
        if(nom.isEmpty() || nom == null || nom.equals("")) {
            throw new Exception("Veuillez indiquer le nom");
        }
        this.nom = nom;
    }

    private String prenom;
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) throws Exception {
        if(prenom.isEmpty() || prenom == null || prenom.equals("")) {
            throw new Exception("Veuillez indiquer le prénom");
        }
        this.prenom = prenom;
    }

    private String sDateNaissance;
    public String getsDateNaissance() {
        return sDateNaissance;
    }
    public void setsDateNaissance(String sDateNaissance) throws Exception {
        if(sDateNaissance == null || sDateNaissance.equalsIgnoreCase("") || sDateNaissance.isEmpty()) {
            throw new Exception("Veuillez indiquer la date de naissance");
        }
        this.setDateNaissance(Date.valueOf(sDateNaissance));
        this.sDateNaissance = sDateNaissance;
    }

    private Date dateNaissance;
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    private int genre;
    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    private String contact;
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    private String motPasse;
    public String getMotPasse() {
        return motPasse;
    }
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    private String confirmationMotPasse;
    public String getConfirmationMotPasse() {
        return confirmationMotPasse;
    }
    public void setConfirmationMotPasse(String confirmationMotPasse) {
        this.confirmationMotPasse = confirmationMotPasse;
    }

    public InscriptionUtilisateur() {}
    public InscriptionUtilisateur(String nom, String prenom, String sDateNaissance, int genre, String email, String contact, String motPasse, String confirmationMotPasse) throws Exception {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setsDateNaissance(sDateNaissance);
        this.setGenre(genre);
        this.setEmail(email);
        this.setContact(contact);
        this.setMotPasse(motPasse);
        this.setConfirmationMotPasse(confirmationMotPasse);
    }
}
