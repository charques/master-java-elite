package edu.masterjava.easybakery.common.util.mapper.recipe;

import java.util.ArrayList;
import java.util.List;

import edu.masterjava.easybakery.common.util.toolset.CommonUtils;
import edu.masterjava.easybakery.persistence.model.recipe.Recipe;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;

/**
 * Mapeador de receta.
 * 
 * @author carloshernandezarques
 */
public class RecipeMapper {

	/**
	 * Construye una lista de RecipeUI a partir de una lista de Recipe.
	 * 
	 * @param recipeList
	 * @return
	 */
	public static List<RecipeUI> toUIBean(List<Recipe> recipeList) {
		List<RecipeUI> out = new ArrayList<RecipeUI>();
		if(CommonUtils.hasElements(recipeList)) {
			for(Recipe recipe : recipeList) {
				RecipeUI item = toUIBean(recipe);
				out.add(item);
			}
		}
		return out;
	}
	
	/**
	 * Construye un RecipeUI a partir de un Recipe.
	 * 
	 * @param recipe
	 * @return
	 */
	public static RecipeUI toUIBean(Recipe recipe) {
		RecipeUI out = new RecipeUI();
		out.setId(recipe.getId());
		out.setDescription(recipe.getDescription());
		out.setComment(recipe.getComment());
		if(CommonUtils.hasElements(recipe.getIngredientList())) {
			out.setIngredientList(IngredientMapper.toUIBean(recipe.getIngredientList()));
		}
		return out;
	}
}
