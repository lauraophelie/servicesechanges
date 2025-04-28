package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.parametres.Critere;

@Repository
public interface CritereRepository extends JpaRepository<Critere, Integer> {

}
