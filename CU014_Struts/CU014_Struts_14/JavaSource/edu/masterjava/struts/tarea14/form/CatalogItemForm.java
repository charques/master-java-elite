 package edu.masterjava.struts.tarea14.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import edu.masterjava.struts.tarea14.vo.Category;

/**
 * Form 
 * 
 * @author carloshernandezarques
 */
public class CatalogItemForm extends ActionForm {
    
	private static final long serialVersionUID = 1L;
	
	private List<Category> categories;
	
	private String insertOrUpdate;
	
	private Integer itemId;
    private String itemName;
    private String autorName;
    private String pubYear;
    private Integer categoryId;
    
    
	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
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
	 * @param itemName the itemName to set
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
	 * @param autorName the autorName to set
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
	 * @param pubYear the pubYear to set
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
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the insertOrUpdate
	 */
	public String getInsertOrUpdate() {
		return insertOrUpdate;
	}
	/**
	 * @param insertOrUpdate the insertOrUpdate to set
	 */
	public void setInsertOrUpdate(String insertOrUpdate) {
		this.insertOrUpdate = insertOrUpdate;
	}
    
    

}
