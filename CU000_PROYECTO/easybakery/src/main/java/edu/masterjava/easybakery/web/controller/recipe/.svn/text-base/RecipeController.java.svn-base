package edu.masterjava.easybakery.web.controller.recipe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.masterjava.easybakery.service.feedstock.FeedstockService;
import edu.masterjava.easybakery.service.recipe.RecipeNotFoundException;
import edu.masterjava.easybakery.service.recipe.RecipeService;
import edu.masterjava.easybakery.web.controller.common.AbstractController;
import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;
import edu.masterjava.easybakery.web.model.recipe.IngredientUI;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;
import edu.masterjava.easybakery.web.validator.recipe.RecipeUIValidator;

/**
 * Controller para la gesti—n de recetas.
 * 
 * @author carloshernandezarques
 */
@Controller
@SessionAttributes("recipe")
public class RecipeController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeController.class);

	protected static final String ERROR_MESSAGE_KEY_DELETED_RECIPE_WAS_NOT_FOUND = "error.message.recipe.deleted.not.found";
	protected static final String ERROR_MESSAGE_KEY_EDITED_RECIPE_WAS_NOT_FOUND = "error.message.recipe.edited.not.found";
    protected static final String ERROR_MESSAGE_KEY_DELETED_RECIPE_INTEGRITY = "error.message.recipe.deleted.integrity";

	protected static final String FEEDBACK_MESSAGE_KEY_RECIPE_CREATED = "feedback.message.recipe.created";
	protected static final String FEEDBACK_MESSAGE_KEY_RECIPE_DELETED = "feedback.message.recipe.deleted";
	protected static final String FEEDBACK_MESSAGE_KEY_RECIPE_EDITED = "feedback.message.recipe.edited";

	protected static final String MODEL_ATTRIRUTE_RECIPE = "recipe";
	protected static final String MODEL_ATTRIBUTE_RECIPES = "recipes";
	protected static final String MODEL_ATTRIRUTE_FEEDSTOCKS_CREATE = "feedstocks";

	protected static final String RECIPE_EDIT_FORM_VIEW = "/recipe/edit";
	protected static final String RECIPE_LIST_VIEW = "/recipe/list";

	@Resource
	private RecipeService recipeService;

	@Resource
	private FeedstockService feedstockService;
	
	@Resource
	private RecipeUIValidator recipeValidator;
	
	/**
     * Devuelve todas las recetas como model attribute
     * @return
     */
    @ModelAttribute(MODEL_ATTRIRUTE_FEEDSTOCKS_CREATE )
    public List<FeedstockUI> getAllFeedstocks() {
        return feedstockService.findAll();
    }

	/**
	 * Procesa las solicitudes de eliminaci—n de recetas.
	 * 
	 * @param id
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/recipe/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes) {
		
		try {
			RecipeUI deleted = recipeService.delete(id);
			addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_RECIPE_DELETED, deleted.getDescription());
		} catch (RecipeNotFoundException e) {
			LOGGER.debug("No se ha encontrado receta con id: " + id);
			addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_RECIPE_WAS_NOT_FOUND);
		}
		catch (DataIntegrityViolationException e) {
            LOGGER.debug("Error de integridad en la receta con id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_RECIPE_INTEGRITY);
        }

		return createRedirectViewPath(RECIPE_LIST_VIEW);
	}

	/**
	 * Procesa las solicitudes GET de creaci—n de recetas.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recipe/edit", method = RequestMethod.GET)
	public String showCreateRecipeForm(Model model) {

		model.addAttribute(MODEL_ATTRIRUTE_RECIPE, (RecipeUI) getDefaultIngredientList());

		return RECIPE_EDIT_FORM_VIEW;
	}

	/**
	 * Procesa las solicitudes GET de edici—n de recetas.
	 * 
	 * @param id
	 * @param model
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/recipe/edit/{id}", method = RequestMethod.GET)
	public String showEditRecipeForm(@PathVariable("id") Integer id, Model model,
			RedirectAttributes attributes) {
		
		RecipeUI recipe = recipeService.findById(id);

		if (recipe == null) {
			LOGGER.debug("No se ha encontrado receta con id: " + id);
			addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_RECIPE_WAS_NOT_FOUND);
			return createRedirectViewPath(RECIPE_LIST_VIEW);
		}

		model.addAttribute(MODEL_ATTRIRUTE_RECIPE, recipe);

		return RECIPE_EDIT_FORM_VIEW;
	}

	/**
	 * Procesa las solicitudes POST de creaci—n/edici—n de recetas.
	 * 
	 * @param recipe
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/recipe/edit", method = RequestMethod.POST)
	public String editRecipeContainer(@Valid @ModelAttribute(MODEL_ATTRIRUTE_RECIPE) RecipeUI recipe,
			BindingResult bindingResult, RedirectAttributes attributes) {

		// validaci—n espec’fica
		recipeValidator.validate(recipe, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return RECIPE_EDIT_FORM_VIEW;
		}

		if (recipe.getId() == null) {
			// crea la receta
			RecipeUI recipeCreated = recipeService.create(recipe);
			addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_RECIPE_CREATED,
					recipeCreated.getDescription());
		} else {
			// actualiza la receta
			try {
				RecipeUI recipeUpdated = recipeService.update(recipe);
				addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_RECIPE_EDITED,
						recipeUpdated.getDescription());
			} catch (RecipeNotFoundException e) {
				LOGGER.debug("No se ha encontrado receta con id: " + recipe.getId());
				addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_RECIPE_WAS_NOT_FOUND);
			}
		}

		return createRedirectViewPath(RECIPE_LIST_VIEW);
	}

	/**
	 * Procesa las solicitudes de listado de recetas.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = RECIPE_LIST_VIEW, method = RequestMethod.GET)
	public String showList(Model model) {

		List<RecipeUI> recipes = recipeService.findAll();
		model.addAttribute(MODEL_ATTRIBUTE_RECIPES, recipes);

		return RECIPE_LIST_VIEW;
	}

	
	private RecipeUI getDefaultIngredientList() {
		List<IngredientUI> recipeItemList = new ArrayList<IngredientUI>();
		recipeItemList.add(new IngredientUI(null, 1));
		return new RecipeUI(recipeItemList);
	}
}
