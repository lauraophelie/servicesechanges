package com.echange.servicesechanges.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echange.servicesechanges.api.ApiReponse;
import com.echange.servicesechanges.auth.JwtUtils;
import com.echange.servicesechanges.model.publication.ClassementReponse;
import com.echange.servicesechanges.repository.DemandeServiceRepository;

@RestController
@RequestMapping("/api/classement")
@CrossOrigin
public class ClassementController {
    private JwtUtils jwtUtils;
    private DemandeServiceRepository repository;

    public ClassementController(JwtUtils jwtUtils, DemandeServiceRepository repository) {
        this.jwtUtils = jwtUtils;
        this.repository = repository;
    }

    @GetMapping("/{idDemande}")
    public ResponseEntity<ApiReponse> getClassement(@PathVariable int idDemande) {
        try {
            List<ClassementReponse> classement = this.repository.getClassement(idDemande);
            ApiReponse api = new ApiReponse(null, classement);

            return ResponseEntity.ok(api);
        } catch (Exception e) {
            ApiReponse reponse = new ApiReponse(e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponse);
        }
    }
}
