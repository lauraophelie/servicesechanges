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
@Table(name = "attribution_note_critere")
public class NoteCritere {
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

    @Column(name = "min")
    private double min;
    public double getMin() {
        return min;
    }
    public void setMin(double min) {
        this.min = min;
    }

    @Column(name = "max")
    private double max;
    public double getMax() {
        return max;
    }
    public void setMax(double max) {
        this.max = max;
    }

    @Column(name = "note")
    private double note;
    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }

    @Column(name = "bonus")
    private double bonus;
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Column(name = "malus")
    private double malus;
    public double getMalus() {
        return malus;
    }
    public void setMalus(double malus) {
        this.malus = malus;
    }
}
