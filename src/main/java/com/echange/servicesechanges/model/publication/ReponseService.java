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
@Table(name="reponse_service")
public class ReponseService {
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
    
    @Column(name = "date_reponse")
    private Date dateReponse;
    public Date getDateReponse() {
        return dateReponse;
    }
    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    @Column(name = "prix_propose")
    private double prixPropose;
    public double getPrixPropose() {
        return prixPropose;
    }
    public void setPrixPropose(double prixPropose) {
        this.prixPropose = prixPropose;
    }

    @Column(name = "date_disponibilite")
    private Date dateDisponibilite;
    public Date getDateDisponibilite() {
        return dateDisponibilite;
    }
    public void setDateDisponibilite(Date dateDisponibilite) {
        this.dateDisponibilite = dateDisponibilite;
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

    @ManyToOne
    @JoinColumn(name = "id_demande_service")
    private DemandeService demandeService;

    public DemandeService getDemandeService() {
        return demandeService;
    }
    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }
}
