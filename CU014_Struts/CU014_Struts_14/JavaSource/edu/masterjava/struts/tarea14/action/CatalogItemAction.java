package edu.masterjava.struts.tarea14.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import edu.masterjava.struts.tarea14.form.CatalogItemForm;
import edu.masterjava.struts.tarea14.service.CatalogItemService;
import edu.masterjava.struts.tarea14.service.CatalogItemServiceImpl;
import edu.masterjava.struts.tarea14.service.CategoryService;
import edu.masterjava.struts.tarea14.service.CategoryServiceImpl;
import edu.masterjava.struts.tarea14.vo.CatalogItem;
import edu.masterjava.struts.tarea14.vo.Category;

public class CatalogItemAction extends LookupDispatchAction {

	private static CatalogItemService catalogItemService = new CatalogItemServiceImpl();
	private static CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected Map getKeyMethodMap() {

		Map<String, String> mp = new HashMap<String, String>();
		mp.put("opcion.new", "newItem");
		mp.put("opcion.edit", "editItem");
		
		mp.put("opcion.save", "saveItem");
		mp.put("opcion.delete", "deleteItem");
		mp.put("opcion.cancel", "cancelItem");
		
		return mp;
	}

	/**
	 * Muestra el formulario en modo creaci—n.
	 */
	public ActionForward newItem(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CatalogItemForm catalogItemForm = (CatalogItemForm) form;
		
		List<Category> categories = categoryService.getAllCategories();
		catalogItemForm.setCategories(categories);
		
		catalogItemForm.setInsertOrUpdate("insert");
		
		return mapping.findForward("success");
	}
	
	/**
	 * Muestra el formulario en modo edici—n.
	 */
	public ActionForward editItem(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CatalogItemForm catalogItemForm = (CatalogItemForm) form;
		
		List<Category> categories = categoryService.getAllCategories();
		catalogItemForm.setCategories(categories);
		
		Integer id = Integer.valueOf(catalogItemForm.getItemId());
		CatalogItem item = catalogItemService.getCatalogItem(id);
		BeanUtils.copyProperties(catalogItemForm, item);
		
		catalogItemForm.setInsertOrUpdate("update");
		
		return mapping.findForward("success");
	}
	
	/**
	 * Inserta un nuevo elemento.
	 */
	public ActionForward saveItem(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CatalogItemForm catalogItemForm = (CatalogItemForm) form;
		
		if("insert".equals(catalogItemForm.getInsertOrUpdate())) {
			CatalogItem item = new CatalogItem();
			BeanUtils.copyProperties(item, catalogItemForm);
			
			catalogItemService.insertCatalogItem(item);
		}
		else if("update".equals(catalogItemForm.getInsertOrUpdate())) {
			Integer id = Integer.valueOf(catalogItemForm.getItemId());
			CatalogItem item = catalogItemService.getCatalogItem(id);
			BeanUtils.copyProperties(item, catalogItemForm);
			
			catalogItemService.updateCatalogItem(item);
		}
		
		return mapping.findForward("catalog");
	}
	
	/**
	 * Elimina un elemento.
	 */
	public ActionForward deleteItem(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CatalogItemForm catalogItemForm = (CatalogItemForm) form;
		
		Integer id = Integer.valueOf(catalogItemForm.getItemId());
		catalogItemService.deleteCatalogItem(id);
		
		return mapping.findForward("catalog");
	}
	
	/**
	 * Cancelaci—n.
	 */
	public ActionForward cancelItem(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("catalog");
	}
	
	/*public ActionForward getCatalogItems(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("getCatalogItems");
		setCatalogAttribute(request);
		setCategoriesAttribute(request);
		return mapping.findForward("success");
	}

	public ActionForward setUpForInsertOrUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("setUpForInsertOrUpdate");
		CatalogItemForm itemForm = (CatalogItemForm) form;
		if (isUpdate(request, itemForm)) {
			Integer id = Integer.valueOf(itemForm.getItemId());
			CatalogItem item = catalogItemService.getCatalogItem(id);
			BeanUtils.copyProperties(itemForm, item);
		}
		setCategoriesAttribute(request);
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("delete");
		CatalogItemForm itemForm = (CatalogItemForm) form;
		Integer id = Integer.valueOf(itemForm.getItemId());
		catalogItemService.deleteCatalogItem(id);
		setCatalogAttribute(request);
		setCategoriesAttribute(request);
		return mapping.findForward("success");
	}

	public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("insertOrUpdate");
		CatalogItemForm itemForm = (CatalogItemForm) form;
		if (validationSuccessful(request, itemForm)) {
			CatalogItem item = new CatalogItem();
			BeanUtils.copyProperties(item, itemForm);
			if (isUpdate(request, itemForm)) {
				System.out.println("update");
				catalogItemService.updateCatalogItem(item);
			} else {
				System.out.println("insert");
				catalogItemService.insertCatalogItem(item);
			}
			setCatalogAttribute(request);
			setCategoriesAttribute(request);
			return mapping.findForward("success");
		} else {
			setCategoriesAttribute(request);
			return mapping.findForward("failure");
		}
	}*/

	/*private void setCatalogAttribute(HttpServletRequest request) {
		List<CatalogItem> items = catalogItemService.getAllCatalog();
		request.setAttribute("catalogItems", items);
	}

	private void setCategoriesAttribute(HttpServletRequest request) {
		request.setAttribute("categories", categoryService.getAllCategories());
	}

	private boolean isUpdate(HttpServletRequest request,
			CatalogItemForm itemForm) {
		boolean updateFlag = true;
		// if ID is null or 0 we know we are doing an insert. You could check
		// other
		// things to decide, like a dispatch param
		// It's annoying that BeanUtils will convert nulls to 0 so have to do 0
		// check also,
		// or you could register a converter, which is the preferred way to
		// handle it, but goes
		// beyond this demo
		String id = itemForm.getItemId();
		if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0)
		{
			updateFlag = false;
		}
		request.setAttribute("updateFlag", Boolean.valueOf(updateFlag));
		return updateFlag;
	}

	private boolean validationSuccessful(HttpServletRequest request,
			CatalogItemForm form) {
		// if you really like using the validation framework stuff, you can just
		// call ActionErrors errors = form.validate( mapping, request ); in this
		// method
		// and check for errors being empty, if not save them and you're done.
		// I end up finding the validation framework a bit annoying to work
		// with, so I do it
		// old-Skool way. Inevitably in a more complex app you end up having to
		// perform
		// more complex validation than the validation framework provides, so I
		// just assume
		// keep it all here in one place, versus having some handled by xml
		// configuration and
		// some hardcoded.
		boolean isOk = true;
		ActionMessages errors = new ActionMessages();
		
		return isOk;
	}*/
}
