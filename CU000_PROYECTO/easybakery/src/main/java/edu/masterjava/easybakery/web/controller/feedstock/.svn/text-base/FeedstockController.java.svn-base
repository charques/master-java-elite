package edu.masterjava.easybakery.web.controller.feedstock;

import java.math.BigDecimal;
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

import edu.masterjava.easybakery.service.feedstock.FeedstockNotFoundException;
import edu.masterjava.easybakery.service.feedstock.FeedstockService;
import edu.masterjava.easybakery.service.feedstock.UnitService;
import edu.masterjava.easybakery.web.controller.common.AbstractController;
import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;
import edu.masterjava.easybakery.web.model.feedstock.UnitUI;

/**
 * Controller para la gesti—n de materias primas.
 * 
 * @author carloshernandezarques
 */
@Controller
@SessionAttributes("feedstock")
public class FeedstockController extends AbstractController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedstockController.class);
    
    protected static final String ERROR_MESSAGE_KEY_DELETED_FEEDSTOCK_WAS_NOT_FOUND = "error.message.feedstock.deleted.not.found";
    protected static final String ERROR_MESSAGE_KEY_DELETED_FEEDSTOCK_INTEGRITY = "error.message.feedstock.deleted.integrity";
    protected static final String ERROR_MESSAGE_KEY_EDITED_FEEDSTOCK_WAS_NOT_FOUND = "error.message.feedstock.edited.not.found";
    
    protected static final String FEEDBACK_MESSAGE_KEY_FEEDSTOCK_CREATED = "feedback.message.feedstock.created";
    protected static final String FEEDBACK_MESSAGE_KEY_FEEDSTOCK_DELETED = "feedback.message.feedstock.deleted";
    protected static final String FEEDBACK_MESSAGE_KEY_FEEDSTOCK_EDITED = "feedback.message.feedstock.edited";
    
    protected static final String MODEL_ATTRIRUTE_FEEDSTOCK = "feedstock";
    protected static final String MODEL_ATTRIBUTE_FEEDSTOCKS = "feedstocks";
    protected static final String MODEL_ATTRIRUTE_UNITS = "units";
    
    protected static final String FEEDSTOCK_EDIT_FORM_VIEW = "/feedstock/edit";
    protected static final String FEEDSTOCK_LIST_VIEW = "/feedstock/list";
    
    @Resource
    private FeedstockService feedstockService;
    
    @Resource
    private UnitService unitService;
    
    /**
     * Devuelve todas las unidades de medida como model attribute
     * @return
     */
    @ModelAttribute(MODEL_ATTRIRUTE_UNITS )
    public List<UnitUI> getAllUnits() {
        return unitService.findAll();
    }

    /**
	 * Procesa las solicitudes de eliminaci—n de materias primas.
	 * 
	 * @param id
	 * @param attributes
	 * @return
	 */
    @RequestMapping(value = "/feedstock/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        
        try {
            FeedstockUI deleted = feedstockService.delete(id);
            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_FEEDSTOCK_DELETED, deleted.getDescription());
        } catch (FeedstockNotFoundException e) {
            LOGGER.debug("No se ha encontrado materia prima con id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_FEEDSTOCK_WAS_NOT_FOUND);
        }
        catch (DataIntegrityViolationException e) {
            LOGGER.debug("Error de integridad en la materia prima con id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_FEEDSTOCK_INTEGRITY);
        }

        return createRedirectViewPath(FEEDSTOCK_LIST_VIEW);
    }

    /**
	 * Procesa las solicitudes GET de creaci—n de materias primas.
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/feedstock/edit", method = RequestMethod.GET) 
    public String showCreateFeedstockForm(Model model) {
        
        model.addAttribute(MODEL_ATTRIRUTE_FEEDSTOCK, (FeedstockUI) getDefaultFeedstockUI());

        return FEEDSTOCK_EDIT_FORM_VIEW;
    }
    
    /**
	 * Procesa las solicitudes GET de edici—n de materias primas.
	 * 
	 * @param id
	 * @param model
	 * @param attributes
	 * @return
	 */
    @RequestMapping(value = "/feedstock/edit/{id}", method = RequestMethod.GET)
    public String showEditFeedstockForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        
        FeedstockUI feedstock = feedstockService.findById(id);
        if (feedstock == null) {
            LOGGER.debug("No se ha encontrado materia prima con id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_FEEDSTOCK_WAS_NOT_FOUND);
            return createRedirectViewPath(FEEDSTOCK_LIST_VIEW);            
        }

        model.addAttribute(MODEL_ATTRIRUTE_FEEDSTOCK, feedstock);
        
        return FEEDSTOCK_EDIT_FORM_VIEW;
    }
    
    /**
	 * Procesa las solicitudes POST de creaci—n/edici—n de materias primas.
	 * 
	 * @param recipe
	 * @param bindingResult
	 * @param attributes
	 * @return
	 */
    @RequestMapping(value = "/feedstock/edit", method = RequestMethod.POST)
    public String submitCreateFeedstockForm(@Valid @ModelAttribute(MODEL_ATTRIRUTE_FEEDSTOCK) FeedstockUI feedstock, BindingResult bindingResult, RedirectAttributes attributes) {
    	
    	if (bindingResult.hasErrors()) {
    		return FEEDSTOCK_EDIT_FORM_VIEW;
        }
        
        if (feedstock.getId() == null) {
        	// crea la materia prima
        	LOGGER.debug("Creando receta");
        	FeedstockUI feedstockCreated = feedstockService.create(feedstock);
        	addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_FEEDSTOCK_CREATED, feedstockCreated.getDescription());
        }
        else {
        	// actualiza la materia prima
        	try {
        		LOGGER.debug("Actualizando receta");
        		FeedstockUI feedstockUpdated = feedstockService.update(feedstock);
                addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_FEEDSTOCK_EDITED, feedstockUpdated.getDescription());
            } catch (FeedstockNotFoundException e) {
                LOGGER.debug("No se ha encontrado materia prima con id: " + feedstock.getId());
                addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_FEEDSTOCK_WAS_NOT_FOUND);
            }
        }

        return createRedirectViewPath(FEEDSTOCK_LIST_VIEW);
    }

    /**
     * Procesa las solicitudes de listado de materias primas.
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = FEEDSTOCK_LIST_VIEW, method = RequestMethod.GET)
    public String showList(Model model) {
        
        List<FeedstockUI> feedstocks = feedstockService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_FEEDSTOCKS, feedstocks);

        return FEEDSTOCK_LIST_VIEW;
    }

    private FeedstockUI getDefaultFeedstockUI() {
    	FeedstockUI feedstock = new FeedstockUI();
    	feedstock.setPrice(new BigDecimal("0.01"));
		return feedstock;
	}
    
}
