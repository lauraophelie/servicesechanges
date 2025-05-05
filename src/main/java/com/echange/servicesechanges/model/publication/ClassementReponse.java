package com.echange.servicesechanges.model.publication;

public class ClassementReponse {
    private int classement;
    public int getClassement() {
        return classement;
    }
    public void setClassement(int classement) {
        this.classement = classement;
    }
    
    private int id_reponse;
    public int getIdReponse() {
        return id_reponse;
    }
    public void setIdReponse(int idReponse) {
        this.id_reponse = idReponse;
    }

    private int id_candidat;
    public int getIdCandidat() {
        return id_candidat;
    }
    public void setIdCandidat(int idCandidat) {
        this.id_candidat = idCandidat;
    }

    private String candidat;
    public String getCandidat() {
        return candidat;
    }
    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    private double note_finale;
    public double getNoteFinale() {
        return note_finale;
    }
    public void setNoteFinale(double noteFinale) {
        this.note_finale = noteFinale;
    }
}
