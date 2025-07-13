package br.unesp.rc.MSCondominiumG1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.rc.MSCondominiumG1.entity.Condominium;

/**
 * Repository interface for the Condominium entity. NOTE: This repository relies
 * on the correction in the Condominium entity (the addition of an @Id field).
 */
@Repository
public interface CondominiumRepository extends JpaRepository<Condominium, Long> {

    /**
     * Finds a Condominium entity by its name. Spring Data JPA will
     * automatically generate the query for this method.
     *
     * @param name The name of the condominium to search for.
     * @return an Optional containing the found condominium, or an empty
     * Optional if not found.
     */
    Optional<Condominium> findByName(String name);

}
