package com.echange.servicesechanges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.echange.servicesechanges.model.publication.ClassementReponse;
import com.echange.servicesechanges.model.publication.DemandeService;
import com.echange.servicesechanges.model.utilisateur.Utilisateur;


@Repository
public interface DemandeServiceRepository extends JpaRepository<DemandeService, Integer> {
    @Query(value = "SELECT classement, id_reponse, id_candidat, candidat, note_finale FROM get_classement_demande(:id_demande)", nativeQuery = true)
    public List<ClassementReponse> getClassement(@Param("id_demande") int idDemande);

    public List<DemandeService> findByUtilisateur(Utilisateur utilisateur);
}
