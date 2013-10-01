package edu.masterjava.easybakery.common.util.mapper.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.masterjava.easybakery.common.util.toolset.CommonUtils;
import edu.masterjava.easybakery.persistence.model.batch.BatchIngredient;
import edu.masterjava.easybakery.web.model.batch.BatchIngredientUI;

/**
 * Mapeador de ingredientes de lote. 
 * 
 * @author carloshernandezarques
 */
public class BatchIngredientMapper {

	/**
	 * Build a List of BatchIngredientUI using a List of BatchIngredient.
	 * 
	 * @param batchIngredientList
	 * @return
	 */
	public static List<BatchIngredientUI> toUIBean(Set<BatchIngredient> batchIngredientList) {

		List<BatchIngredientUI> out = new ArrayList<BatchIngredientUI>();
		if (CommonUtils.hasElements(batchIngredientList)) {
			for (BatchIngredient batchIngredient : batchIngredientList) {
				BatchIngredientUI item = toUIBean(batchIngredient);
				out.add(item);
			}
		}
		return out;
	}
	
	/**
	 * Build a BatchIngredientUI using a BatchIngredient.
	 * @param batchIngredient
	 * @return
	 */
	public static BatchIngredientUI toUIBean(BatchIngredient batchIngredient) {
		BatchIngredientUI out = new BatchIngredientUI();
        
        out.setId(batchIngredient.getId());
        out.setAmount(batchIngredient.getAmount());
        out.setPercentage(batchIngredient.getPercentage());
        out.setFeedstockPrice(batchIngredient.getFeedstockPrice());
        out.setDescription(batchIngredient.getDescription());
        
        return out;
    }
}
