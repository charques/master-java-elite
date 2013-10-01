package edu.masterjava.easybakery.web.controller.batch;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.masterjava.easybakery.common.util.json.JsonResponse;
import edu.masterjava.easybakery.common.util.mapper.batch.BatchMapper;
import edu.masterjava.easybakery.service.batch.BatchNotFoundException;
import edu.masterjava.easybakery.service.batch.BatchService;
import edu.masterjava.easybakery.service.recipe.RecipeService;
import edu.masterjava.easybakery.web.controller.common.AbstractController;
import edu.masterjava.easybakery.web.model.batch.BatchUI;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;

/**
 * Controller para la gesti—n de lotes.
 * 
 * @author carloshernandezarques
 */
@Controller
@SessionAttributes("batch")
public class BatchController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchController.class);

	protected static final String ERROR_MESSAGE_KEY_DELETED_BATCH_WAS_NOT_FOUND = "error.message.batch.deleted.not.found";
	protected static final String ERROR_MESSAGE_KEY_EDITED_BATCH_WAS_NOT_FOUND = "error.message.batch.edited.not.found";
	protected static final String ERROR_MESSAGE_KEY_EDITED_RECIPE_WAS_NOT_FOUND = "error.message.recipe.edited.not.found";

	protected static final String FEEDBACK_MESSAGE_KEY_BATCH_CREATED = "feedback.message.batch.created";
	protected static final String FEEDBACK_MESSAGE_KEY_BATCH_DELETED = "feedback.message.batch.deleted";
	protected static final String FEEDBACK_MESSAGE_KEY_BATCH_EDITED = "feedback.message.batch.edited";

	protected static final String MODEL_ATTRIRUTE_BATCH = "batch";
	protected static final String MODEL_ATTRIBUTE_BATCHS = "batchs";
	protected static final String MODEL_ATTRIBUTE_RECIPES = "recipes";

	protected static final String BATCH_ADD_FORM_VIEW = "/batch/add";
	protected static final String BATCH_EDIT_FORM_VIEW = "/batch/edit";
	protected static final String BATCH_LIST_VIEW = "/batch/list";

	@Resource
	private BatchService batchService;

	@Resource
	private RecipeService recipeService;
	
	/**
     * Devuelve todas las recetas como model attribute
     * @return
     */
    @ModelAttribute(MODEL_ATTRIBUTE_RECIPES )
    public List<RecipeUI> getAllRecipes() {
        return recipeService.findAll();
    }

    /**
	 * Procesa las solicitudes de eliminaci—n de lotes.
	 * 
	 * @param id
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/batch/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes) {

		try {
			BatchUI deleted = batchService.delete(id);
			addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_BATCH_DELETED, deleted.getDescription());
		} catch (BatchNotFoundException e) {
			LOGGER.debug("No se ha encontrado lote con id: " + id);
			addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_BATCH_WAS_NOT_FOUND);
		}

		return createRedirectViewPath(BATCH_LIST_VIEW);
	}

	
	/**
	 * Procesa las solicitudes GET de edici—n de lote.
	 * @param id
	 * @param model
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/batch/edit/{id}", method = RequestMethod.GET)
	public String showEditBatchForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {

		BatchUI batch = batchService.findById(id);

		if (batch == null) {
			LOGGER.debug("No se ha encontrado lote con id: " + id);
			addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_BATCH_WAS_NOT_FOUND);
			return createRedirectViewPath(BATCH_LIST_VIEW);
		}

		model.addAttribute(MODEL_ATTRIRUTE_BATCH, batch);

		return BATCH_EDIT_FORM_VIEW;
	}

	/**
	 * Procesa las solicitudes POST de edici—n de lote.
	 * 
	 * @param batch
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/batch/edit", method = RequestMethod.POST)
	public String editBatch(@Valid @ModelAttribute(MODEL_ATTRIRUTE_BATCH) BatchUI batch,
			BindingResult bindingResult, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return BATCH_ADD_FORM_VIEW;
		}

		// actualiza el lote
		try {
			LOGGER.debug("Actualizando lote");
			BatchUI batchUpdated = batchService.update(batch);
			addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_BATCH_EDITED, batchUpdated.getDescription());
		} catch (BatchNotFoundException e) {
			LOGGER.debug("No se ha encontrado lote con id: " + batch.getId());
			addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_BATCH_WAS_NOT_FOUND);
		}

		return createRedirectViewPath(BATCH_LIST_VIEW);
	}

	/**
	 * Procesa las solicitudes GET de creaci—n de lote.
	 * 
	 * @param id
	 * @param model
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/batch/add", method = RequestMethod.GET)
	public String showCreateBatchForm(Model model) {

		model.addAttribute(MODEL_ATTRIRUTE_BATCH, (BatchUI) getDefaultBatchUI());

		return BATCH_ADD_FORM_VIEW;
	}

	/**
	 * Procesa las solicitudes POST de creaci—n de lote.
	 * 
	 * @param batch
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/batch/add", method = RequestMethod.POST)
	public String createBatch(@Valid @ModelAttribute(MODEL_ATTRIRUTE_BATCH) BatchUI batch,
			BindingResult bindingResult, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return BATCH_ADD_FORM_VIEW;
		}

		// creando lote
		LOGGER.debug("Creando lote");
		BatchUI batchCreated = batchService.create(batch);
		addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_BATCH_CREATED, batchCreated.getDescription());

		return createRedirectViewPath(BATCH_LIST_VIEW);
	}

	/**
	 * Procesa las solicitudes AJAX para obtener la configuraci—n de un lote basado en una receta.
	 * @param batchUi
	 * @param result
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/batch/getRecipe", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getRecipeAJAX(@Valid @ModelAttribute(MODEL_ATTRIRUTE_BATCH) BatchUI batchUi,
			BindingResult result, RedirectAttributes attributes) {

		JsonResponse res = new JsonResponse();

		RecipeUI recipe = recipeService.findById(batchUi.getRecipeId());
		if (recipe == null) {
			LOGGER.debug("No se ha encontrado lote con id: " + batchUi.getRecipeId());
			res.setResult(ERROR_MESSAGE_KEY_EDITED_BATCH_WAS_NOT_FOUND);
			res.setStatus("FAIL");
		} else {

			BatchUI batch = new BatchUI();
			batch.setRecipeId(batchUi.getRecipeId());
			batch.setTotalAmount(batchUi.getTotalAmount());
			batch = BatchMapper.mixBeans(batch, recipe);
			batch = batchService.calcBatch(batch);
			res.setResult(batch);
			res.setStatus("SUCCESS");
		}

		return res;
	}

	/**
     * Procesa las solicitudes de listado de lotes.
     * 
     * @param model
     * @return 
     */
	@RequestMapping(value = BATCH_LIST_VIEW, method = RequestMethod.GET)
	public String showList(Model model) {

		List<BatchUI> batchs = batchService.findAll();
		model.addAttribute(MODEL_ATTRIBUTE_BATCHS, batchs);

		return BATCH_LIST_VIEW;
	}

	private BatchUI getDefaultBatchUI() {
		BatchUI batchUI = new BatchUI();
		batchUI.setDescription("-");
		batchUI.setTotalAmount(1000d);
		return batchUI;
	}
}