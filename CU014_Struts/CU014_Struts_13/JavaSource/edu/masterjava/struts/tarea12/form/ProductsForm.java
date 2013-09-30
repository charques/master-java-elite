package edu.masterjava.struts.tarea12.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class ProductsForm extends ActionForm {
	
	private List<CartItemForm> products;

	/**
	 * @return the products
	 */
	public List<CartItemForm> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<CartItemForm> products) {
		this.products = products;
	}
	
	
}
