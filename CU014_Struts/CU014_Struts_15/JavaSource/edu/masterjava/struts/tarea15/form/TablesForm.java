package edu.masterjava.struts.tarea15.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class TablesForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private List<String> tablas;

	private String nombreTabla;

	private List<String> descTabla;

	public TablesForm() {
		super();
	}

	/**
	 * @return the tablas
	 */
	public List<String> getTablas() {
		return tablas;
	}

	/**
	 * @param tablas
	 *            the tablas to set
	 */
	public void setTablas(List<String> tablas) {
		this.tablas = tablas;
	}

	/**
	 * @return the descTabla
	 */
	public List<String> getDescTabla() {
		return descTabla;
	}

	/**
	 * @param descTabla
	 *            the descTabla to set
	 */
	public void setDescTabla(List<String> descTabla) {
		this.descTabla = descTabla;
	}

	/**
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}

	/**
	 * @param nombreTabla
	 *            the nombreTabla to set
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	/**
	 * Validate
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);

		return errors;
	}

}
