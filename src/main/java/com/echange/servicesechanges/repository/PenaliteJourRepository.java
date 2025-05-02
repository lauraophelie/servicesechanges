package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.parametres.systeme.PenaliteJour;

@Repository
public interface PenaliteJourRepository extends JpaRepository<PenaliteJour, Integer> {

}
