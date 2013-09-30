package edu.masterjava.struts.tarea08;

import java.util.ArrayList;

public class InputForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String checkbox;
	
	private String file;
	
	private String hidden;
	
	private String[] multiboxItems = {};
	
	private String password;
	
	private String radio;

	private String select;

	private ArrayList<SelectData> selectList;
	
	private String text;
	
	private String textarea;

	public InputForm() {
		super();
	}

	/**
	 * @return the checkbox
	 */
	public String getCheckbox() {
		return checkbox;
	}

	/**
	 * @param checkbox the checkbox to set
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the hidden
	 */
	public String getHidden() {
		return hidden;
	}

	/**
	 * @param hidden the hidden to set
	 */
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	/**
	 * @return the multiboxItems
	 */
	public String[] getMultiboxItems() {
		return multiboxItems;
	}

	/**
	 * @param multiboxItems the multiboxItems to set
	 */
	public void setMultiboxItems(String[] multiboxItems) {
		this.multiboxItems = multiboxItems;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the radio
	 */
	public String getRadio() {
		return radio;
	}

	/**
	 * @param radio the radio to set
	 */
	public void setRadio(String radio) {
		this.radio = radio;
	}

	/**
	 * @return the select
	 */
	public String getSelect() {
		return select;
	}

	/**
	 * @param select the select to set
	 */
	public void setSelect(String select) {
		this.select = select;
	}

	/**
	 * @return the selectList
	 */
	public ArrayList<SelectData> getSelectList() {
		return selectList;
	}

	/**
	 * @param selectList the selectList to set
	 */
	public void setSelectList(ArrayList<SelectData> selectList) {
		this.selectList = selectList;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the textarea
	 */
	public String getTextarea() {
		return textarea;
	}

	/**
	 * @param textArea the textarea to set
	 */
	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	
}
