package edu.masterjava.easybakery.web.validator.recipe;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import edu.masterjava.easybakery.common.util.toolset.CommonUtils;
import edu.masterjava.easybakery.web.model.recipe.IngredientUI;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;

/**
 * Validador de recetas. Comprueba ingredientes incompletos y errores
 * de formato en porcentaje.
 * 
 * @author carloshernandezarques
 */
@Component
public class RecipeUIValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return RecipeUI.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		RecipeUI recipe = (RecipeUI) target;

		// procesa los errores de porcentajes con error de formato
		for (ObjectError error : errors.getAllErrors()) {
			if("typeMismatch".equals(error.getCode())) {
				errors.rejectValue("ingredientList", "typeMismatch.ingredientList.percentage",
						new Object[] { recipe.getIngredientList() }, null);
				break;
			}		
		}

		// comprueba los ingredientes incompletos
		if (CommonUtils.hasElements(recipe.getIngredientList())) {
			for (IngredientUI ing : recipe.getIngredientList()) {
				if ((ing.getFeedstockId() == null) || (ing.getPercentage() == null)) {
					errors.rejectValue("ingredientList", "NotNull.recipe.ingredientList",
							new Object[] { recipe.getIngredientList() }, null);
					break;
				}
			}
		}
	}
}