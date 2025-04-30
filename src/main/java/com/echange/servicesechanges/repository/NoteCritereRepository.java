package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.parametres.NoteCritere;

@Repository
public interface NoteCritereRepository extends JpaRepository<NoteCritere, Integer> {

}
