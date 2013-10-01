package edu.masterjava.easybakery.common.util.mapper.recipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.masterjava.easybakery.persistence.model.recipe.Ingredient;
import edu.masterjava.easybakery.persistence.model.recipe.Recipe;
import edu.masterjava.easybakery.web.model.recipe.IngredientUI;

/**
 * Colecci—n de ingredientes de receta.
 * 
 * @author carloshernandezarques
 */
public class IngredientCollection implements Iterable<Ingredient> {

	private static final Integer DELETE_FALSE = 0;
	
	private List<Ingredient> ingredients;

	public IngredientCollection(List<Ingredient> list) {
		ingredients = list;
	}
	
	public IngredientCollection(List<IngredientUI> list, Recipe recipe) {
		ingredients = new ArrayList<Ingredient>();
		for(IngredientUI ingredientUi : list) {
			if(ingredientUi.getDelete().equals(DELETE_FALSE)) {
				Ingredient ingredient = Ingredient.getBuilder(recipe, ingredientUi.getFeedstockId(), ingredientUi.getPercentage()).build();
				ingredients.add(ingredient);
			}
		}
	}

	@Override
	public Iterator<Ingredient> iterator() {
		return ingredients.iterator();
	}

}
