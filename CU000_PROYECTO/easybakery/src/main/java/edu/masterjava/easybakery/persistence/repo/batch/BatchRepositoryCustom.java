package edu.masterjava.easybakery.persistence.repo.batch;

import java.util.List;

import edu.masterjava.easybakery.persistence.model.batch.BatchStatistics;

/**
 * Interfaz del repositorio de operaciones personalizadas de lotes.
 * 
 * @author carloshernandezarques
 */
public interface BatchRepositoryCustom {

	List<Integer> getBatchYears();
	
	BatchStatistics getBatchStatisticsByYear(BatchStatistics statistics);
}
