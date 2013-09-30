/**
 * 
 */
package edu.masterjava.struts.tarea14.service;

import java.util.List;

import edu.masterjava.struts.tarea14.dao.CategoryDao;
import edu.masterjava.struts.tarea14.dao.CategoryDaoImpl;
import edu.masterjava.struts.tarea14.vo.Category;

/**
 * Implementaci—n del servicio de gesti—n de categorias.
 * 
 * @author carloshernandezarques
 *
 */
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	
	/**
	 * Constructor.
	 */
	public CategoryServiceImpl() {
		categoryDao = new CategoryDaoImpl();
	}
	
	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.service.CategoryService#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

}
