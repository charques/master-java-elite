package edu.masterjava.easybakery.service.batch;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.masterjava.easybakery.common.util.mapper.batch.BatchIngredientCollection;
import edu.masterjava.easybakery.common.util.mapper.batch.BatchMapper;
import edu.masterjava.easybakery.persistence.model.batch.Batch;
import edu.masterjava.easybakery.persistence.model.batch.BatchIngredient;
import edu.masterjava.easybakery.persistence.repo.batch.BatchIngredientRepository;
import edu.masterjava.easybakery.persistence.repo.batch.BatchRepository;
import edu.masterjava.easybakery.web.model.batch.BatchIngredientUI;
import edu.masterjava.easybakery.web.model.batch.BatchUI;

/**
 * Implementaci—n del servicio de lotes.
 * 
 * @author carloshernandezarques
 */
@Service
public class BatchServiceImpl implements BatchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchServiceImpl.class);

	@Resource
	private BatchRepository batchRepository;

	@Resource
	private BatchIngredientRepository batchIngredientRepository;

	@Transactional
	@Override
	public BatchUI create(BatchUI created) {

		// Guarda un lote
		Batch batch = Batch.getBuilder(created.getDescription(), created.getRecipeId(),
				created.getTotalAmount(), created.getBatchCost()).build();
		batch = batchRepository.save(batch);

		// Guarda los ingredientes del lote
		BatchIngredientCollection ingredients = new BatchIngredientCollection(created.getIngredients(), batch);
		batchIngredientRepository.save(ingredients);

		return BatchMapper.toUIBean(batch);
	}

	@Transactional(rollbackFor = BatchNotFoundException.class)
	@Override
	public BatchUI delete(Integer batchId) throws BatchNotFoundException {

		Batch deleted = batchRepository.findOne(batchId);

		if (deleted == null) {
			LOGGER.debug("No se ha encontrado el lote con id: " + batchId);
			throw new BatchNotFoundException();
		}

		batchRepository.delete(deleted);
		return BatchMapper.toUIBean(deleted);
	}

	@Transactional(readOnly = true)
	@Override
	public List<BatchUI> findAll() {
		List<Batch> batchs = batchRepository.findAll();
		return BatchMapper.toUIBean(batchs);
	}

	@Transactional(readOnly = true)
	@Override
	public BatchUI findById(Integer id) {
		Batch batch = batchRepository.findOne(id);
		return BatchMapper.toUIBean(batch);
	}

	@Transactional(rollbackFor = BatchNotFoundException.class)
	@Override
	public BatchUI update(BatchUI updated) throws BatchNotFoundException {

		Batch batch = batchRepository.findOne(updated.getId());

		if (batch == null) {
			LOGGER.debug("No se ha encontrado el lote con id: " + updated.getId());
			throw new BatchNotFoundException();
		}
		
		// Calcula el lote
		updated = this.calcBatch(updated);
		
		// Actualiza
		batch.update(updated.getDescription(), updated.getTotalAmount(), updated.getBatchCost());

		// Elimina todos los ingredientes
		List<BatchIngredient> ingredientList = batchIngredientRepository.findByBatchId(batch.getId());
		BatchIngredientCollection collection = new BatchIngredientCollection(ingredientList);
		batchIngredientRepository.deleteInBatch(collection);

		// Guarda los ingredientes
		BatchIngredientCollection ingredients = new BatchIngredientCollection(updated.getIngredients(), batch);
		batchIngredientRepository.save(ingredients);

		return BatchMapper.toUIBean(batch);
	}

	@Override
	public BatchUI calcBatch(BatchUI batch) {
		Double cost = 0d;
		for (BatchIngredientUI batchIngredient : batch.getIngredients()) {
			Double amount = batch.getTotalAmount() * batchIngredient.getPercentage() / 100;
			batchIngredient.setAmount(amount);

			cost += batchIngredient.getAmount() * batchIngredient.getFeedstockPrice().doubleValue();
		}
		batch.setBatchCost(BigDecimal.valueOf(cost));
		return batch;
	}

}
