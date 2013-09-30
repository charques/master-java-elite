package edu.masterjava.struts.tarea14.service;

import java.util.List;

import edu.masterjava.struts.tarea14.vo.CatalogItem;

/**
 * Interface del servicio de gesti—n del cat‡logo.
 * 
 * @author carloshernandezarques
 */
public interface CatalogItemService {
	
    public List<CatalogItem> getAllCatalog();
    public void updateCatalogItem(CatalogItem item);
    public void deleteCatalogItem(Integer id);
    public CatalogItem getCatalogItem(Integer id);
    public void insertCatalogItem(CatalogItem item);
}
