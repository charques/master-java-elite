package edu.masterjava.jsf.tarea04.vo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import edu.masterjava.jsf.tarea04.service.IContactService;

@ManagedBean
public class ContactConverter implements Converter {

	// Servicio de negocio
	@ManagedProperty("#{ContactServiceImpl}")
	private IContactService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null) {
			return null;
		}
		int id = Integer.parseInt(value);

		return this.service.findById(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null) {
			return null;
		}
		Integer id = ((Contact) value).getId();

		return (id != null) ? id.toString() : null;
	}

	/**
	 * @return the service
	 */
	public IContactService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(IContactService service) {
		this.service = service;
	}

}
