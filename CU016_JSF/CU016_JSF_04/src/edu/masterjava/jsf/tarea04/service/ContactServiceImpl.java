/**
 * @author <a href=mailto:volkodavav@gmail.com>volkodavav</a>
 */
package edu.masterjava.jsf.tarea04.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import edu.masterjava.jsf.tarea04.dao.ContactDAO;
import edu.masterjava.jsf.tarea04.dao.ICrudDAO;
import edu.masterjava.jsf.tarea04.vo.Contact;

@ManagedBean(name = "ContactServiceImpl")
@ApplicationScoped
public class ContactServiceImpl implements IContactService, Serializable
{
    private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{ContactDAO}")
    private ICrudDAO<Contact, Integer> dao;

    @Override
    public long count()
    {
        return this.dao.count();
    }

    @Override
    public Contact create()
    {
        return this.dao.create();
    }

    @Override
    public void delete(Contact entity)
    {
        this.dao.delete(entity);
    }

    @Override
    public int deleteAll()
    {
        return this.dao.deleteAll();
    }

    @Override
    public List<Contact> findAll()
    {
        return new ArrayList<Contact>(this.dao.findAll());
    }

    @Override
    public Contact findById(Integer id)
    {
        return this.dao.findById(id);
    }

    @PostConstruct
    public void postConstruct()
    {
        if (this.dao == null)
        {
            this.dao = new ContactDAO();
        }
    }

    @PreDestroy
    public void preDestroy()
    {
        this.dao = null;
    }

    @Override
    public void save(Contact entity)
    {
        this.dao.save(entity);
    }

    public void setDao(ICrudDAO<Contact, Integer> dao)
    {
        this.dao = dao;
    }

    @Override
    public Contact update(Contact entity)
    {
        return this.dao.update(entity);
    }
}