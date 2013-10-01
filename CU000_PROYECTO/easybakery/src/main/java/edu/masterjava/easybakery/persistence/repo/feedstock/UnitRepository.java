package edu.masterjava.easybakery.persistence.repo.feedstock;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.masterjava.easybakery.persistence.model.feedstock.Unit;

/**
 * Repositorio de unidades de medida.
 * 
 * @author carloshernandezarques
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    
}
