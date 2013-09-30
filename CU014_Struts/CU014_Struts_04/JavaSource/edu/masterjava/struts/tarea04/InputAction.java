package edu.masterjava.struts.tarea04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class InputAction extends DispatchAction {

	private final static String SHOW = "show";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		 HttpSession session = request.getSession();
		 session.setAttribute("pSession", form);		

		return mapping.findForward(SHOW);
	}

}