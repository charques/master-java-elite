package edu.masterjava.struts.tarea14.dao;

import java.util.List;

import edu.masterjava.struts.tarea14.vo.CatalogItem;

/**
 * Interface del DAO de gesti—n del catalogo.
 * 
 * @author carloshernandezarques
 */
public interface CatalogItemDao {
   
	public List<CatalogItem> getAllCatalogItems();
    public CatalogItem getCatalogItem(Integer id);
    public void update(CatalogItem item);
    public void insert(CatalogItem item);
    public void delete(Integer id);
}
