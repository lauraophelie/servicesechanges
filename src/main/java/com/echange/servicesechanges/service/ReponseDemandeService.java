package com.echange.servicesechanges.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.echange.servicesechanges.model.publication.ReponseService;
import com.echange.servicesechanges.repository.ReponseServiceRepository;

@Service
public class ReponseDemandeService {
    private ReponseServiceRepository repository;

    public ReponseDemandeService(ReponseServiceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ReponseService save(ReponseService reponse) {
        return this.repository.save(reponse);
    }
}
