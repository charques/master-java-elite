package edu.masterjava.struts.tarea12.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.masterjava.struts.tarea12.form.CartItemForm;
import edu.masterjava.struts.tarea12.form.ProductsForm;

public class ProductsAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ProductsForm productsForm = (ProductsForm) form;
		
		productsForm.setProducts(buildProductsFake());

		return mapping.findForward("success");
	}

	private List<CartItemForm> buildProductsFake() {
		List<CartItemForm> products = new ArrayList<CartItemForm>();
		
		CartItemForm item1 = new CartItemForm();
		item1.setDescription("Producto 1");
		item1.setUnitCost(10);
		item1.setId("PROD0001");
		products.add(item1);
		
		CartItemForm item2 = new CartItemForm();
		item2.setDescription("Producto 2");
		item2.setUnitCost(10);
		item2.setId("PROD0002");
		products.add(item2);
		
		return products;
	}
	
}
