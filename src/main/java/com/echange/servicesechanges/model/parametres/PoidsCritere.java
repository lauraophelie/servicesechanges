package com.echange.servicesechanges.model.parametres;

import com.echange.servicesechanges.model.publication.DemandeService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attribution_poids_critere")
public class PoidsCritere {
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

    @ManyToOne
    @JoinColumn(name = "id_demande_service")
    private DemandeService demandeService;
    public DemandeService getDemandeService() {
        return demandeService;
    }
    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_critere")
    private Critere critere;
    public Critere getCritere() {
        return critere;
    }
    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    @Column(name = "poids")
    private double poids;
    public double getPoids() {
        return poids;
    }
    public void setPoids(double poids) {
        this.poids = poids;
    }
}
