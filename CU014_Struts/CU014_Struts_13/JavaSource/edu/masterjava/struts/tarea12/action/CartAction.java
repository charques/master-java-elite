package edu.masterjava.struts.tarea12.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import edu.masterjava.struts.tarea12.bo.CartBO;
import edu.masterjava.struts.tarea12.form.CartItemForm;

public class CartAction extends LookupDispatchAction {

	public static final String SESSION_CART = "shoppingCart";

	@Override
	protected Map getKeyMethodMap() {
		
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("opcion.add", "addToCart");
		mp.put("opcion.update", "updateCart");
		mp.put("opcion.delete", "deleteCart");
		return mp;
	}

	public ActionForward deleteCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CartItemForm cartItemForm = (CartItemForm) form;
		
		HttpSession session = request.getSession();
		String strItemIndex = cartItemForm.getIndex();
		CartBO cartBO = null;

		Object objCartBean = session.getAttribute(SESSION_CART);
		if (objCartBean == null) {
			cartBO = new CartBO();
		} else {
			cartBO = (CartBO) objCartBean;
		}
		cartBO.deleteItem(strItemIndex);
		
		return mapping.findForward("success");
	}

	public ActionForward updateCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CartItemForm cartItemForm = (CartItemForm) form;
		
		HttpSession session = request.getSession();
		String itemIndex = cartItemForm.getIndex();
		System.out.println("itemIndex : " + itemIndex);
		String quantity = Integer.toString(cartItemForm.getQuantity());
		
		CartBO cartBO = null;
		Object objCartBean = session.getAttribute(SESSION_CART);
		if (objCartBean == null) {
			cartBO = new CartBO();
		} else {
			cartBO = (CartBO) objCartBean;
		}
		
		cartBO.updateItem(itemIndex, quantity);
		
		return mapping.findForward("success");
	}

	public ActionForward addToCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String productId = request.getParameter("id");
		String productDesc = request.getParameter("description");
		String productCost = request.getParameter("cost");

		CartBO cartBO = null;

		Object objCartBean = session.getAttribute(SESSION_CART);

		if (objCartBean == null) {
			System.out.println("Se ha creado el carro!");
			cartBO = new CartBO();
			session.setAttribute(SESSION_CART, cartBO);
			
		} else {
			cartBO = (CartBO) objCartBean;
		}

		cartBO.addItem(productId, productDesc, productCost);
		
		return mapping.findForward("success");
	}

	

}
