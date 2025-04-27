package com.echange.servicesechanges.model.publication;

import java.sql.Date;

import com.echange.servicesechanges.model.utilisateur.Utilisateur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="demande_service")
public class DemandeService {
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
    
    @Column(name = "date_creation")
    private Date dateCreation;
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name = "description_service")
    private String descriptionService;
    public String getDescriptionService() {
        return descriptionService;
    }
    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    @Column(name = "date_besoin_service")
    private Date dateBesoinService;
    public Date getDateBesoinService() {
        return dateBesoinService;
    }
    public void setDateBesoinService(Date dateBesoinService) {
        this.dateBesoinService = dateBesoinService;
    }

    @Column(name = "prix")
    private double prix;
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Column(name = "intitule_service")
    private String intituleService;
    public String getIntituleService() {
        return intituleService;
    }
    public void setIntituleService(String intituleService) {
        this.intituleService = intituleService;
    }
}
