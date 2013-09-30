/**
 * 
 */
package edu.masterjava.struts.tarea14.service;

import java.util.List;

import edu.masterjava.struts.tarea14.dao.CatalogItemDao;
import edu.masterjava.struts.tarea14.dao.CatalogItemDaoImpl;
import edu.masterjava.struts.tarea14.vo.CatalogItem;

/**
 * Implementaci—n del servicio de gesti—n del cat‡logo.
 * @author carloshernandezarques
 *
 */
public class CatalogItemServiceImpl implements CatalogItemService {

	private CatalogItemDao catalogItemDao;
	
	/**
	 * Constructor.
	 */
	public CatalogItemServiceImpl() {
		catalogItemDao = new CatalogItemDaoImpl();
	}
	
	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.service.CatalogItemService#getAllCatalog()
	 */
	@Override
	public List<CatalogItem> getAllCatalog() {
		return catalogItemDao.getAllCatalogItems();
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.service.CatalogItemService#updateCatalogItem(edu.masterjava.struts.tarea14.vo.CatalogItem)
	 */
	@Override
	public void updateCatalogItem(CatalogItem emp) {
		catalogItemDao.update(emp);
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.service.CatalogItemService#deleteCatalogItem(java.lang.Integer)
	 */
	@Override
	public void deleteCatalogItem(Integer id) {
		catalogItemDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.service.CatalogItemService#getCatalogItem(java.lang.Integer)
	 */
	@Override
	public CatalogItem getCatalogItem(Integer id) {
		return catalogItemDao.getCatalogItem(id);
	}

	/* (non-Javadoc)
	 * @see edu.masterjava.struts.tarea14.service.CatalogItemService#insertCatalogItem(edu.masterjava.struts.tarea14.vo.CatalogItem)
	 */
	@Override
	public void insertCatalogItem(CatalogItem emp) {
		catalogItemDao.insert(emp);
	}

}
