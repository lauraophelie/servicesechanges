package com.echange.servicesechanges.model.utilisateur;

public class LoginReponse {
    private String contact;
    
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    private String token;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public LoginReponse() {}
    public LoginReponse(String contact, String token) {
        this.setContact(contact);
        this.setToken(token);
    }
}
