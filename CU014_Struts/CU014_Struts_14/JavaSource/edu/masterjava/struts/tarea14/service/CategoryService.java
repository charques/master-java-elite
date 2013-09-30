package edu.masterjava.struts.tarea14.service;

import java.util.List;

import edu.masterjava.struts.tarea14.vo.Category;

/**
 * Interface del servicio de gesti—n de categorias.
 * 
 * @author carloshernandezarques
 */
public interface CategoryService {
	
    public List<Category> getAllCategories();
}
