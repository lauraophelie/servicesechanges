package com.echange.servicesechanges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.utilisateur.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    @Query(value = "SELECT * FROM v_utilisateur WHERE contact = :contact", nativeQuery = true)
    public Utilisateur findByContact(@Param("contact") String contact);
}
