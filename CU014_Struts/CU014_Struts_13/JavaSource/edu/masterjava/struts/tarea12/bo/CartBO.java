package edu.masterjava.struts.tarea12.bo;

import java.util.ArrayList;

import edu.masterjava.struts.tarea12.form.CartItemForm;

public class CartBO {

	private ArrayList<CartItemForm> items = new ArrayList<CartItemForm>();
	private double cartTotal;

	public int getLineItemCount() {
		return items.size();
	}

	public void deleteItem(String pItemIndex) {
		int iItemIndex = 0;
		try {
			iItemIndex = Integer.parseInt(pItemIndex);
			items.remove(iItemIndex);
			calcCartTotal();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	public void updateItem(String pItemIndex, String pQuantity) {
		double totalCost = 0.0;
		double unitCost = 0.0;
		int quantity = 0;
		int itemIndex = 0;
		CartItemForm cartItem = null;
		try {
			itemIndex = Integer.parseInt(pItemIndex);
			quantity = Integer.parseInt(pQuantity);
			if (quantity > 0) {
				cartItem = (CartItemForm) items.get(itemIndex);
				unitCost = cartItem.getUnitCost();
				totalCost = unitCost * quantity;
				cartItem.setQuantity(quantity);
				cartItem.setTotalCost(totalCost);
				calcCartTotal();
			}
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	public void addItem(String productId, String productDesc, String productCost) {

		double unitCost = 0.0;
		CartItemForm cartItem = new CartItemForm();
		try {
			unitCost = Double.parseDouble(productCost);
			cartItem.setId(productId);
			cartItem.setDescription(productDesc);
			cartItem.setUnitCost(unitCost);
			cartItem.setQuantity(1);
;			cartItem.setTotalCost(unitCost*1);
			items.add(cartItem);
			calcCartTotal();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	public CartItemForm getCartItem(int iItemIndex) {
		CartItemForm cartItem = null;
		if (items.size() > iItemIndex) {
			cartItem = items.get(iItemIndex);
		}
		return cartItem;
	}

	protected void calcCartTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < items.size(); counter++) {
			CartItemForm cartItem = (CartItemForm) items.get(counter);
			dblTotal += cartItem.getTotalCost();
		}
		setCartTotal(dblTotal);
	}

	/**
	 * @return the items
	 */
	public ArrayList<CartItemForm> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(ArrayList<CartItemForm> items) {
		this.items = items;
	}

	/**
	 * @return the cartTotal
	 */
	public double getCartTotal() {
		return cartTotal;
	}

	/**
	 * @param cartTotal
	 *            the cartTotal to set
	 */
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

}
