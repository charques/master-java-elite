package edu.masterjava.struts.tarea14.dao;

import java.util.List;

import edu.masterjava.struts.tarea14.vo.Category;

/**
 * Interface del DAO de gesti—n del categorias.
 * 
 * @author carloshernandezarques
 */
public interface CategoryDao {
   
	public List<Category> getAllCategories();
}
