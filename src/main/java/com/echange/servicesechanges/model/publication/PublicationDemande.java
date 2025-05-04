package com.echange.servicesechanges.model.publication;

import java.util.List;

import com.echange.servicesechanges.exception.InvalidPublicationDemandeException;
import com.echange.servicesechanges.model.parametres.NoteCritere;
import com.echange.servicesechanges.model.parametres.PoidsCritere;

public class PublicationDemande {
    private DemandeService demandeService;

    public DemandeService getDemandeService() {
        return demandeService;
    }
    public void setDemandeService(DemandeService demandeService) throws InvalidPublicationDemandeException {
        if(demandeService == null) {
            throw new InvalidPublicationDemandeException("La publication composée ne doit pas être vide, veuillez remplir les informations requises");
        }
        this.demandeService = demandeService;
    }
    
    private ParametrageService parametrageService;

    public ParametrageService getParametrageService() {
        return parametrageService;
    }
    public void setParametrageService(ParametrageService parametrageService) throws InvalidPublicationDemandeException {
        if(parametrageService == null) {
            throw new InvalidPublicationDemandeException("Le paramétrage du service ne doit pas être vide. Veuillez remplir les informations requises.");
        }
        this.parametrageService = parametrageService;
    }

    private List<NoteCritere> listeNotesCriteres;

    public List<NoteCritere> getListeNotesCriteres() {
        return listeNotesCriteres;
    }
    public void setListeNotesCriteres(List<NoteCritere> listeNotesCriteres) throws InvalidPublicationDemandeException {
        if(listeNotesCriteres == null || listeNotesCriteres.isEmpty() || listeNotesCriteres.size() == 0) {
            throw new InvalidPublicationDemandeException("Veuillez remplir les notes des critères");
        }
        this.listeNotesCriteres = listeNotesCriteres;
    }

    private List<PoidsCritere> listePoidsCriteres;

    public List<PoidsCritere> getListePoidsCriteres() {
        return listePoidsCriteres;
    }
    public void setListePoidsCriteres(List<PoidsCritere> listePoidsCriteres) throws InvalidPublicationDemandeException {
        if(listePoidsCriteres == null || listePoidsCriteres.size() == 0 || listePoidsCriteres.isEmpty()) {
            throw new InvalidPublicationDemandeException("Veuillez remplir les poids des critères");
        }
        this.listePoidsCriteres = listePoidsCriteres;
    }

    public PublicationDemande() {}
    public PublicationDemande(
        DemandeService demandeService, ParametrageService parametrageService,
        List<NoteCritere> listeNotesCriteres, List<PoidsCritere> listePoidsCriteres
    ) throws InvalidPublicationDemandeException {
        this.setDemandeService(demandeService);
        this.setParametrageService(parametrageService);
        this.setListeNotesCriteres(listeNotesCriteres);
        this.setListePoidsCriteres(listePoidsCriteres);
    }
}
