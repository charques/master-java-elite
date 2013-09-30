package edu.masterjava.struts.tarea14.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.masterjava.struts.tarea14.form.CatalogForm;
import edu.masterjava.struts.tarea14.service.CatalogItemService;
import edu.masterjava.struts.tarea14.service.CatalogItemServiceImpl;
import edu.masterjava.struts.tarea14.vo.CatalogItem;

public class CatalogAction extends Action {
	
    private static CatalogItemService catalogItemService = new CatalogItemServiceImpl();

    public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CatalogForm catalogForm = (CatalogForm) form;
		
		List<CatalogItem> catalog = catalogItemService.getAllCatalog();
		catalogForm.setCatalog(catalog);

		return mapping.findForward("success");
	}

}
