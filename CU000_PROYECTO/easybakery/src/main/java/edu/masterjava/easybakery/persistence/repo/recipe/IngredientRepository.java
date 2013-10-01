package edu.masterjava.easybakery.persistence.repo.recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import edu.masterjava.easybakery.persistence.model.recipe.Ingredient;

/**
 * Repositorio de ingrediente.
 * 
 * @author carloshernandezarques
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer>,
		JpaSpecificationExecutor<Ingredient> {

	List<Ingredient> findByRecipeId(Integer recipeId);

}
