package com.echange.servicesechanges.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.echange.servicesechanges.model.parametres.NoteCritere;
import com.echange.servicesechanges.repository.NoteCritereRepository;

@Service
public class AttributionNoteService {
    private NoteCritereRepository repository;

    public AttributionNoteService(NoteCritereRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<NoteCritere> saveAll(int idPublication, List<NoteCritere> listeNote) {
        if (listeNote == null || listeNote.isEmpty()) {
            throw new IllegalArgumentException("La liste des notes critères ne peut pas être vide");
        }
        for (int i = 0; i < listeNote.size(); i++) {
            listeNote.get(i).getDemandeService().setId(idPublication);
        }
        return this.repository.saveAll(listeNote);
    }
}
