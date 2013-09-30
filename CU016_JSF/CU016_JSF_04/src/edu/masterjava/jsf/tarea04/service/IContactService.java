/**
 * @author <a href=mailto:volkodavav@gmail.com>volkodavav</a>
 */
package edu.masterjava.jsf.tarea04.service;

import java.util.List;

import edu.masterjava.jsf.tarea04.vo.Contact;

public abstract interface IContactService
{
    public abstract long count();

    public abstract Contact create();

    public abstract void delete(Contact entity);

    public abstract int deleteAll();

    public abstract List<Contact> findAll();

    public abstract Contact findById(Integer id);

    public abstract void save(Contact entity);

    public abstract Contact update(Contact entity);
}