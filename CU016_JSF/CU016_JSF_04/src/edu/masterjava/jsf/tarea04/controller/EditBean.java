package edu.masterjava.jsf.tarea04.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.masterjava.jsf.tarea04.service.ContactServiceImpl;
import edu.masterjava.jsf.tarea04.service.IContactService;
import edu.masterjava.jsf.tarea04.vo.Contact;

@ManagedBean(name = "editBean")
@ViewScoped
public class EditBean implements Serializable {
	private static final long serialVersionUID = 1L;

	// Servicio de negocio
	@ManagedProperty("#{ContactServiceImpl}")
	private IContactService service;

	// Contacto
	private Contact contact = new Contact();

	@PostConstruct
	public void postConstruct() {
		init();
	}

	private void init() {
		if (this.service == null) {
			this.service = new ContactServiceImpl();
		}
	}

	@PreDestroy
	public void preDestroy() {
		destroy();
	}

	/**
	 * Destroy
	 */
	private void destroy() {
		this.service = null;
		this.contact = null;
	}

	/**
	 * Prerender
	 */
	public void preRenderView() {
		if (contact == null) {
			contact = new Contact();
		}
	}
	
	/**
	 * Guardar y actualizar.
	 * @return
	 */
	public String save() {
		if (contact.getId() != null) {
			service.update(contact);
		} else {
			service.save(contact);
		}

		return "index.xhtml?faces-redirect=true";
	}

	/**
	 * Eliminar
	 * @return
	 */
	public String delete() { 
		if (contact.getId() != null) {
			service.delete(contact);
		}
		return "index.xhtml?faces-redirect=true";
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

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
}