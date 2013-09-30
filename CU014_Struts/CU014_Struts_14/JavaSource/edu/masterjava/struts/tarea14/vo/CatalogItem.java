package edu.masterjava.struts.tarea14.vo;

import java.io.Serializable;

/**
 * Item de cat‡logo.
 * 
 * @author carloshernandezarques
 */
public class CatalogItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer itemId;
	private String itemName;
	private String autorName;
	private String pubYear;
	private Integer categoryId;
	private String categoryDesc;

	public CatalogItem() {
	}

	public CatalogItem(Integer itemId, String itemName, String autorName,
			String pubYear, Integer categoryId, String categoryDesc) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.autorName = autorName;
		this.pubYear = pubYear;
		this.categoryId = categoryId;
		this.categoryDesc = categoryDesc;
	}

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the autorName
	 */
	public String getAutorName() {
		return autorName;
	}

	/**
	 * @param autorName
	 *            the autorName to set
	 */
	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	/**
	 * @return the pubYear
	 */
	public String getPubYear() {
		return pubYear;
	}

	/**
	 * @param pubYear
	 *            the pubYear to set
	 */
	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryDesc
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}

	/**
	 * @param categoryDesc the categoryDesc to set
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	
	

}
