package com.echange.servicesechanges.model.utilisateur;

public class LoginUtilisateur {
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

    public LoginUtilisateur() {}
    public LoginUtilisateur(String contact, String motPasse) {
        this.setContact(contact);
        this.setMotPasse(motPasse);
    }
}
