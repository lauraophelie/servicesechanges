package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.publication.ParametrageService;

@Repository
public interface ParametrageServiceRepository extends JpaRepository<ParametrageService, Integer> {

}
