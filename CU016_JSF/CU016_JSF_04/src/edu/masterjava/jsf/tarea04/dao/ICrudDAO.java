package edu.masterjava.jsf.tarea04.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface ICrudDAO<T, ID extends Serializable>
{
    public abstract long count();

    public abstract T create();

    public abstract void delete(T entity);

    public abstract int deleteAll();

    public abstract List<T> findAll();

    public abstract T findById(ID id);

    public abstract void save(T entity);

    public abstract T update(T entity);
}