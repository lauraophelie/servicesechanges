package com.echange.servicesechanges.service;

import org.springframework.stereotype.Service;

import com.echange.servicesechanges.model.publication.ParametrageService;
import com.echange.servicesechanges.repository.ParametrageServiceRepository;

import jakarta.transaction.Transactional;

@Service
public class ParametrageDemandeService {
    private ParametrageServiceRepository repository;

    public ParametrageDemandeService(ParametrageServiceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ParametrageService save(int idPublication, ParametrageService params) {
        params.getDemandeService().setId(idPublication);
        return this.repository.save(params);
    }
}
