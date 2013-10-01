package edu.masterjava.easybakery.persistence.repo.batch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.masterjava.easybakery.persistence.model.batch.BatchIngredient;

/**
 * Repositorio de ingrediente asociado a un lote.
 * 
 * @author carloshernandezarques
 */
public interface BatchIngredientRepository extends JpaRepository<BatchIngredient, Integer> {
 
	List<BatchIngredient> findByBatchId(Integer batchId);
}
