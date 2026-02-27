package br.unesp.rc.MSCondominiumG1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.rc.MSCondominiumG1.entity.Area;

/**
 * Repository interface for Area entity. This will allow us to perform CRUD
 * operations on the Area table and its children (Common, Specific,
 * RentableArea) thanks to the JOINED inheritance strategy.
 */
@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    /**
     * Finds an Area entity by its name. Spring Data JPA will automatically
     * generate the query for this method based on its name. It will look for an
     * Area where the 'name' column matches the given parameter. We use
     * Optional<Area> as the return type, which is a good practice to handle
     * cases where no area with the given name is found.
     *
     * @param name The name of the area to search for.
     * @return an Optional containing the found area, or an empty Optional if
     * not found.
     */
    Optional<Area> findByName(String name);
}
