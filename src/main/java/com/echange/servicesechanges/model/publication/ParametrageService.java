package com.echange.servicesechanges.model.publication;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "parametrage_demande_service")
public class ParametrageService {
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
    
    @OneToOne
    @JoinColumn(name = "id_demande_service")
    private DemandeService demandeService;
    public DemandeService getDemandeService() {
        return demandeService;
    }
    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @Column(name = "date_limite_reponse")
    private Date dateLimiteReponse;
    public Date getDateLimiteReponse() {
        return dateLimiteReponse;
    }
    public void setDateLimiteReponse(Date dateLimiteReponse) {
        this.dateLimiteReponse = dateLimiteReponse;
    }

    @Column(name = "marge_disponibilite")
    private int margeDisponibilite;
    public int getMargeDisponibilite() {
        return margeDisponibilite;
    }
    public void setMargeDisponibilite(int margeDisponibilite) {
        this.margeDisponibilite = margeDisponibilite;
    }

    @Column(name = "min_prix_propose")
    private double minPrixPropose;
    public double getMinPrixPropose() {
        return minPrixPropose;
    }
    public void setMinPrixPropose(double minPrixPropose) {
        this.minPrixPropose = minPrixPropose;
    }

    @Column(name = "max_prix_propose")
    private double maxPrixPropose;
    public double getMaxPrixPropose() {
        return maxPrixPropose;
    }
    public void setMaxPrixPropose(double maxPrixPropose) {
        this.maxPrixPropose = maxPrixPropose;
    }
}
