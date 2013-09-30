package edu.masterjava.struts.tarea08;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class InputAction extends DispatchAction {

	private final static String INPUT = "input";
	private final static String SHOW = "show";

	public ActionForward populate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ArrayList<SelectData> selectList = new ArrayList<SelectData>();
		InputForm inputForm = (InputForm) form;

		selectList.add(new SelectData("1", "Valor 1"));
		selectList.add(new SelectData("2", "Valor 2"));
		selectList.add(new SelectData("3", "Valor 3"));

		inputForm.setSelectList(selectList);

		return mapping.findForward(INPUT);
	}

	public ActionForward enviar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward(SHOW);
	}
}