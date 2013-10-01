package edu.masterjava.easybakery.service.recipe;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.masterjava.easybakery.common.util.mapper.recipe.IngredientCollection;
import edu.masterjava.easybakery.common.util.mapper.recipe.RecipeMapper;
import edu.masterjava.easybakery.persistence.model.recipe.Ingredient;
import edu.masterjava.easybakery.persistence.model.recipe.Recipe;
import edu.masterjava.easybakery.persistence.repo.recipe.IngredientRepository;
import edu.masterjava.easybakery.persistence.repo.recipe.RecipeRepository;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;

/**
 * Implementaci—n del servicio de recetas.
 * 
 * @author carloshernandezarques
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeServiceImpl.class);

	@Resource
	private RecipeRepository recipeRepository;

	@Resource
	private IngredientRepository ingredientRepository;

	@Transactional
	@Override
	public RecipeUI create(RecipeUI created) {
		
		// Guarda la receta
		Recipe recipe = Recipe.getBuilder(created.getDescription(), created.getComment()).build();
		recipe = recipeRepository.save(recipe);

		// Guarda los ingredientes
		IngredientCollection ingredients = new IngredientCollection(created.getIngredientList(), recipe);
		ingredientRepository.save(ingredients);

		return RecipeMapper.toUIBean(recipe);
	}

	@Transactional(rollbackFor = RecipeNotFoundException.class)
	@Override
	public RecipeUI delete(Integer recipeId) throws RecipeNotFoundException, DataIntegrityViolationException {
		Recipe deleted = recipeRepository.findOne(recipeId);

		if (deleted == null) {
			LOGGER.debug("No se ha encontrado la receta con id: " + recipeId);
			throw new RecipeNotFoundException();
		}

		recipeRepository.delete(deleted);
		return RecipeMapper.toUIBean(deleted);
	}

	@Transactional(readOnly = true)
	@Override
	public List<RecipeUI> findAll() {
		List<Recipe> recipes = recipeRepository.findAll(); 
		return RecipeMapper.toUIBean(recipes);
	}

	@Transactional(readOnly = true)
	@Override
	public RecipeUI findById(Integer id) {
		Recipe recipe = recipeRepository.findOne(id);
		return RecipeMapper.toUIBean(recipe);
	}

	@Transactional(rollbackFor = RecipeNotFoundException.class)
	@Override
	public RecipeUI update(RecipeUI updated) throws RecipeNotFoundException {
		
		// Actualiza la receta
		Recipe recipe = recipeRepository.findOne(updated.getId());
		if (recipe == null) {
			LOGGER.debug("No se ha encontrado la receta con id: " + updated.getId());
			throw new RecipeNotFoundException();
		}
		recipe.update(updated.getDescription(), updated.getComment());

		// Elimina los ingredientes
		List<Ingredient> ingredientList = ingredientRepository.findByRecipeId(recipe.getId());
		IngredientCollection collection = new IngredientCollection(ingredientList);
		ingredientRepository.deleteInBatch(collection);

		// Guarda los ingredientes
		IngredientCollection ingredients = new IngredientCollection(updated.getIngredientList(), recipe);
		ingredientRepository.save(ingredients);

		return RecipeMapper.toUIBean(recipe);
	}
}
