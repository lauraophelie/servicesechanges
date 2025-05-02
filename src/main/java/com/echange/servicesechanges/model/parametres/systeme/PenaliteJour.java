package com.echange.servicesechanges.model.parametres.systeme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parametrage_penalite_jour")
public class PenaliteJour {
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
    
    @Column(name = "valeur_min")
    private int valeurMin;
    public int getValeurMin() {
        return valeurMin;
    }
    public void setValeurMin(int valeurMin) {
        this.valeurMin = valeurMin;
    }

    @Column(name = "valeur_max")
    private int valeurMax;
    public int getValeurMax() {
        return valeurMax;
    }
    public void setValeurMax(int valeurMax) {
        this.valeurMax = valeurMax;
    }

    @Column(name = "valeur_penalite")
    private int penalite;
    public int getPenalite() {
        return penalite;
    }
    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }
}
