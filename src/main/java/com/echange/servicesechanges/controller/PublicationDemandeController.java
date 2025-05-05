package com.echange.servicesechanges.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echange.servicesechanges.api.ApiReponse;
import com.echange.servicesechanges.auth.JwtUtils;
import com.echange.servicesechanges.model.publication.DemandeService;
import com.echange.servicesechanges.model.publication.ParametrageService;
import com.echange.servicesechanges.model.publication.PublicationDemande;
import com.echange.servicesechanges.service.AttributionNoteService;
import com.echange.servicesechanges.service.AttributionPoidsService;
import com.echange.servicesechanges.service.ParametrageDemandeService;
import com.echange.servicesechanges.service.PublicationDemandeService;

import com.echange.servicesechanges.model.parametres.NoteCritere;
import com.echange.servicesechanges.model.parametres.PoidsCritere;

@RestController
@RequestMapping("api/publication/demande")
@CrossOrigin("*")
public class PublicationDemandeController {
    private PublicationDemandeService publicationDemandeService;
    private ParametrageDemandeService parametrageDemandeService;
    private AttributionNoteService attributionNoteService;
    private AttributionPoidsService attributionPoidsService;
    private JwtUtils jwtUtils;

    public PublicationDemandeController(
        PublicationDemandeService publicationDemandeService,
        ParametrageDemandeService parametrageDemandeService, 
        AttributionNoteService attributionNoteService,
        AttributionPoidsService attributionPoidsService,
        JwtUtils jwtUtils
    ) {
        this.publicationDemandeService = publicationDemandeService;
        this.parametrageDemandeService = parametrageDemandeService;
        this.attributionNoteService = attributionNoteService;
        this.attributionPoidsService = attributionPoidsService;
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<ApiReponse> publierDemande(@RequestBody PublicationDemande publicationDemande) {
        try {
            DemandeService demande = this.publicationDemandeService.save(publicationDemande.getDemandeService());
            ParametrageService params = this.parametrageDemandeService.save(demande.getId(), publicationDemande.getParametrageService());
            List<NoteCritere> listeNotes = this.attributionNoteService.saveAll(demande.getId(), publicationDemande.getListeNotesCriteres());
            List<PoidsCritere> listePoids = this.attributionPoidsService.saveAll(demande.getId(), publicationDemande.getListePoidsCriteres());

            ApiReponse api = new ApiReponse(null, demande);
            return ResponseEntity.ok(api);
        } catch (Exception e) {
            ApiReponse reponse = new ApiReponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponse);
        }
    }
}
