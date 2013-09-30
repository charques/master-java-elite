package edu.masterjava.jsf.tarea04.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.masterjava.jsf.tarea04.service.ContactServiceImpl;
import edu.masterjava.jsf.tarea04.service.IContactService;
import edu.masterjava.jsf.tarea04.vo.Contact;

@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	// Servicio de negocio
	@ManagedProperty("#{ContactServiceImpl}")
	private IContactService service;
	
	// Lista de contactos
	private List<Contact> contacts;

	@PostConstruct
	public void postConstruct()
	{
		init();
	}

	@PreDestroy
	public void preDestroy()
	{
		destroy();
	}
	
	/**
	 * MŽtodo de inicializaci—n.
	 */
	private void init()
	{
		if (this.service == null)
		{
			this.service = new ContactServiceImpl();
		}

		this.contacts = this.service.findAll();
	}

	/**
	 * MŽtodo de destrucci—n.
	 */
	private void destroy()
	{
		this.service = null;
		this.contacts = null;
	}

	/**
	 * @return the service
	 */
	public IContactService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(IContactService service) {
		this.service = service;
	}

	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	
}