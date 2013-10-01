package edu.masterjava.easybakery.common.util.mapper.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.masterjava.easybakery.common.util.mapper.feedstock.FeedstockMapper;
import edu.masterjava.easybakery.persistence.model.feedstock.Feedstock;
import edu.masterjava.easybakery.persistence.model.recipe.Ingredient;
import edu.masterjava.easybakery.web.model.recipe.IngredientUI;

/**
 * Mapeador de ingrediente de receta.
 * 
 * @author carloshernandezarques
 */
public class IngredientMapper {
	
	/**
	 * Construye una lista de IngredientUI a partir de una lista de Ingredient.
	 * 
	 * @param ingredientList
	 * @return
	 */
	public static List<IngredientUI> toUIBean(Set<Ingredient> ingredientList) {
		
		List<IngredientUI> out = new ArrayList<IngredientUI>();
		if(!ingredientList.isEmpty()) {
			for(Ingredient ingredient : ingredientList) {
				out.add(toUIBean(ingredient));
			}
		}
		return out;
	}
	
	/**
	 * Construye un IngredientUI a partir de un Ingredient.
	 * 
	 * @param ingredient
	 * @return
	 */
	public static IngredientUI toUIBean(Ingredient ingredient) {
		IngredientUI ingredientUI = new IngredientUI();
		ingredientUI.setId(ingredient.getId());
		ingredientUI.setFeedstockId(ingredient.getFeedstock().getId());
		ingredientUI.setDescription(ingredient.getFeedstock().getDescription());
		ingredientUI.setPercentage(ingredient.getPercentage());
		Feedstock feedstock = ingredient.getFeedstock();
		if (feedstock != null) {
			ingredientUI.setFeedstock(FeedstockMapper.toUIBean(feedstock));
		}
		return ingredientUI;
	}
}
