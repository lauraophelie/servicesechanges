package com.echange.servicesechanges.service;

import org.springframework.stereotype.Service;

import com.echange.servicesechanges.model.publication.DemandeService;
import com.echange.servicesechanges.repository.DemandeServiceRepository;

@Service
public class PublicationDemandeService {
    private DemandeServiceRepository repository;

    public PublicationDemandeService(DemandeServiceRepository repository) {
        this.repository = repository;
    }
    public DemandeService save(DemandeService demande) {
        return this.repository.save(demande);
    }
}
