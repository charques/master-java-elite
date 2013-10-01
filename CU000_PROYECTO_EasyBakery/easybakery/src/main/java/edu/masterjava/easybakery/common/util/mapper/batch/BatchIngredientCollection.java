package edu.masterjava.easybakery.common.util.mapper.batch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.masterjava.easybakery.persistence.model.batch.Batch;
import edu.masterjava.easybakery.persistence.model.batch.BatchIngredient;
import edu.masterjava.easybakery.web.model.batch.BatchIngredientUI;

/**
 * Colecci—n de ingredientes de lote.
 * 
 * @author carloshernandezarques
 */
public class BatchIngredientCollection implements Iterable<BatchIngredient> {
	
	private List<BatchIngredient> ingredients;

	public BatchIngredientCollection(List<BatchIngredient> list) {
		ingredients = list;
	}
	
	public BatchIngredientCollection(List<BatchIngredientUI> list, Batch batch) {
		ingredients = new ArrayList<BatchIngredient>();
		for(BatchIngredientUI ingredientUi : list) {
			BatchIngredient batchIngredient = BatchIngredient.getBuilder(batch, ingredientUi.getIngredientId(), ingredientUi.getDescription(), ingredientUi.getPercentage(), ingredientUi.getFeedstockPrice(), ingredientUi.getAmount()).build();
			ingredients.add(batchIngredient);
		}
	}

	@Override
	public Iterator<BatchIngredient> iterator() {
		return ingredients.iterator();
	}

}
