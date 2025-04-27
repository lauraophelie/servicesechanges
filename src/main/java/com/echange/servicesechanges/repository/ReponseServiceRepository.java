package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.publication.ReponseService;

@Repository
public interface ReponseServiceRepository extends JpaRepository<ReponseService, Integer> {

}
