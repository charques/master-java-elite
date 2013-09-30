package edu.masterjava.struts.tarea14.vo;

import java.io.Serializable;

/**
 * Categor’a
 * 
 * @author carloshernandezarques
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	String categoryId;
	String categoryName;

	public Category() {
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
