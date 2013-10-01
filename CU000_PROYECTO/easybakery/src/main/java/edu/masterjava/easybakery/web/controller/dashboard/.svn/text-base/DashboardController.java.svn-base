package edu.masterjava.easybakery.web.controller.dashboard;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.masterjava.easybakery.common.util.json.JsonResponse;
import edu.masterjava.easybakery.service.dashboard.DashboardService;
import edu.masterjava.easybakery.service.dashboard.GraphDataException;
import edu.masterjava.easybakery.service.recipe.RecipeService;
import edu.masterjava.easybakery.web.controller.common.AbstractController;
import edu.masterjava.easybakery.web.model.dashboard.BatchGraphUI;
import edu.masterjava.easybakery.web.model.dashboard.GraphUI;
import edu.masterjava.easybakery.web.model.recipe.RecipeUI;

/**
 * Controller para la gesti—n del panel de estad’sticas.
 * 
 * @author carloshernandezarques
 */
@Controller
@SessionAttributes("batchgraph")
public class DashboardController extends AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

	protected static final String MODEL_ATTRIRUTE_BATCHGRAPH = "batchgraph";
	protected static final String MODEL_ATTRIRUTE_YEARS = "years";
	protected static final String MODEL_ATTRIRUTE_RECIPES = "recipes";
	protected static final String MODEL_ATTRIRUTE_GRAPH_TYPES = "graphtypes";

	protected static final String DASHBOARD_VIEW = "/dashboard/view";

	@Resource
	private DashboardService dashboardService;
	
	@Resource
	private RecipeService recipeService;

	/**
	 * Procesa las sollicitudes a la vista del panel de estad’sticas.
	 * 
	 * @param model
	 * @return.
	 */
	@RequestMapping(value = "/dashboard/view", method = RequestMethod.GET)
	public String showDashboard(Model model) {

		model.addAttribute(MODEL_ATTRIRUTE_BATCHGRAPH, (BatchGraphUI) getDefaultBatchGraphUI());
		model.addAttribute(MODEL_ATTRIRUTE_YEARS, (List<Integer>) dashboardService.getYearList());
		model.addAttribute(MODEL_ATTRIRUTE_RECIPES, (List<RecipeUI>) recipeService.findAll());
		model.addAttribute(MODEL_ATTRIRUTE_GRAPH_TYPES, (Map<String,String>) getGraphTypes());

		return DASHBOARD_VIEW;
	}

	/**
	 * Procesa la solicitud AJAX para recuperar una gr‡fica.
	 * 
	 * @param batchgraph
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/dashboard/getBatchGraph", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getBatchGraph(@ModelAttribute(MODEL_ATTRIRUTE_BATCHGRAPH) BatchGraphUI batchgraph,
			BindingResult bindingResult, RedirectAttributes attributes) {

		JsonResponse response = new JsonResponse();
		
		try {
			batchgraph = dashboardService.getGraph(batchgraph);
			GraphUI graph = batchgraph.getGraph();
			response.setResult(graph);
			response.setStatus("SUCCESS");
		} 
		catch (GraphDataException e) {
			LOGGER.debug("getBatchGraph: FAIL");
			response.setResult("");
			response.setStatus("FAIL");
		}
		
		return response;
	}
	
	
    private BatchGraphUI getDefaultBatchGraphUI() {
    	BatchGraphUI batchGraph = new BatchGraphUI();
		return batchGraph;
	}
    
    private Map<String,String> getGraphTypes() {
    	Map<String,String> graphTypes = new LinkedHashMap<String,String>();
    	graphTypes.put("PR", "Producci—n (kg)");
    	graphTypes.put("CO", "Costes (Û)");
    	return graphTypes;
    }

}
