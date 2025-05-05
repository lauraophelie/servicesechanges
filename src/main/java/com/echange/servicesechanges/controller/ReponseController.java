package com.echange.servicesechanges.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echange.servicesechanges.api.ApiReponse;
import com.echange.servicesechanges.auth.JwtUtils;
import com.echange.servicesechanges.model.publication.ReponseService;
import com.echange.servicesechanges.service.ReponseDemandeService;

@RestController
@RequestMapping("/api/postule/reponse")
@CrossOrigin("*")
public class ReponseController {
    private ReponseDemandeService service;
    private JwtUtils jwtUtils;

    public ReponseController(ReponseDemandeService service, JwtUtils jwtUtils) {
        this.service = service;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping
    public ResponseEntity<ApiReponse> postulerDemande(@RequestBody ReponseService reponseDemande) {
        try {
            ReponseService rep = this.service.save(reponseDemande);
            ApiReponse api = new ApiReponse(null, rep);

            return ResponseEntity.ok(api);
        } catch (Exception e) {
            ApiReponse reponse = new ApiReponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponse);
        }
    }
}
