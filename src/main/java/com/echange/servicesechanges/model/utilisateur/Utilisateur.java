package com.echange.servicesechanges.model.utilisateur;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nom")
    private String nom;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "prenom")
    private String prenom;

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name = "date_naissance")
    private Date dateNaissance;

    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Column(name = "genre")
    private int genre;

    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }

    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "contact")
    private String contact;

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "mot_passe")
    private String motPasse;

    public String getMotPasse() {
        return motPasse;
    }
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
                + ", genre=" + genre + ", email=" + email + ", contact=" + contact + ", motPasse=" + motPasse + "]";
    }
}
