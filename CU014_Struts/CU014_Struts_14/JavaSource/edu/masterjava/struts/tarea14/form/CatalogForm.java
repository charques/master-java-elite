package edu.masterjava.struts.tarea14.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import edu.masterjava.struts.tarea14.vo.CatalogItem;

/**
 * Form
 * 
 * @author carloshernandezarques
 */
public class CatalogForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private List<CatalogItem> catalog;

	private String itemId;

	/**
	 * @return the catalog
	 */
	public List<CatalogItem> getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog
	 *            the catalog to set
	 */
	public void setCatalog(List<CatalogItem> catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
