package com.echange.servicesechanges.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.echange.servicesechanges.model.parametres.PoidsCritere;
import com.echange.servicesechanges.repository.PoidsCritereRepository;

import jakarta.transaction.Transactional;

@Service
public class AttributionPoidsService {
    private PoidsCritereRepository repository;

    public AttributionPoidsService(PoidsCritereRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<PoidsCritere> saveAll(int idPublication, List<PoidsCritere> listePoids) {
        if (listePoids == null || listePoids.isEmpty()) {
            throw new IllegalArgumentException("La liste des poids critères ne peut pas être vide");
        }
        for (int i = 0; i < listePoids.size(); i++) {
            listePoids.get(i).getDemandeService().setId(idPublication);
        }
        return this.repository.saveAll(listePoids);
    }
}
