package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.publication.DemandeService;

@Repository
public interface DemandeServiceRepository extends JpaRepository<DemandeService, Integer> {

}
