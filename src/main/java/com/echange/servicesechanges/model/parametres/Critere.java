package com.echange.servicesechanges.model.parametres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "critere")
public class Critere {
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

    @Column(name = "designation_critere")
    private String designationCritere;
    public String getDesignationCritere() {
        return designationCritere;
    }
    public void setDesignationCritere(String designationCritere) {
        this.designationCritere = designationCritere;
    }

    public Critere() {}
    public Critere(int id, String designationCritere) {
        this.setId(id);
        this.setDesignationCritere(designationCritere);
    }
}
