package edu.masterjava.easybakery.common.util.mapper.batch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import edu.masterjava.easybakery.common.util.toolset.CommonUtils;
import edu.masterjava.easybakery.persistence.model.batch.Batch;
import edu.masterjava.easybakery.web.model.batch.BatchIngredientUI;
import edu.masterjava.easybakery.web.model.batch.BatchUI;
import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;
import edu.masterjava.easybakery.web.model.recipe.IngredientUI;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;

/**
 * Mapeador de lotes.
 * 
 * @author carloshernandezarques
 */
public class BatchMapper {

	/**
	 * Construye una lista de BatchUI a partir de una lista de Batch.
	 * 
	 * @param batchList
	 * @return
	 */
	public static List<BatchUI> toUIBean(List<Batch> batchList) {

		List<BatchUI> out = new ArrayList<BatchUI>();
		if (CommonUtils.hasElements(batchList)) {
			for (Batch batch : batchList) {
				BatchUI item = toUIBean(batch);
				out.add(item);
			}
		}
		return out;
	}
	
	/**
	 * Construye un BatchUI a partir de un Batch.
	 * @param batch
	 * @return
	 */
	public static BatchUI toUIBean(Batch batch) {
        BatchUI out = new BatchUI();
        
        out.setId(batch.getId());
        out.setDescription(batch.getDescription());
        out.setTotalAmount(batch.getTotalAmount());
        out.setModificationTime(batch.getModificationTime());
        out.setBatchCost(batch.getBatchCost());
        out.setRecipeId(batch.getRecipeId());
        out.setIngredients(BatchIngredientMapper.toUIBean(batch.getIngredients()));
        
        return out;
    }
	
	/**
	 * Contruye un lote a partir de una receta.
	 * @param batch
	 * @param recipe
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static BatchUI mixBeans(BatchUI batch, RecipeUI recipe) {
		List<BatchIngredientUI> ingredients = LazyList.decorate(new ArrayList<BatchIngredientUI>(),
				FactoryUtils.instantiateFactory(BatchIngredientUI.class));
		// Create BatchIngredients
		for(IngredientUI ing : recipe.getIngredientList()) {
			BatchIngredientUI batchIng = new BatchIngredientUI();
			batchIng.setIngredientId(ing.getId());
			batchIng.setDescription(ing.getDescription());
			batchIng.setPercentage(ing.getPercentage());
			batchIng.setAmount(1d);
			FeedstockUI feedstock = ing.getFeedstock();
			if(feedstock != null) {
				batchIng.setFeedstockPrice(feedstock.getPrice());
			}
			ingredients.add(batchIng);
		}
		batch.setIngredients(ingredients);
		
		// Create description
		SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
		String fecha = sdf.format(new Date());
		batch.setDescription(recipe.getDescription() + " - " + fecha);
		
		return batch;
	}
}
