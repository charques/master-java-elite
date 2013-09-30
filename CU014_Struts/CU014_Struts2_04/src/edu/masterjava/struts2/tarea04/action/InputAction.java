package edu.masterjava.struts2.tarea04.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class InputAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String usuario;
	
	private String password;
	
	private String sex;
	
	private String comentarios;
	
	private String provincia;
	
	private ArrayList<Option> listaProvincias;
	
	private String[] multi;
	
	private ArrayList<String> multiList;
	
	private Boolean opcionSimple;

	/**
	 * MŽtodo populate
	 * @return
	 */
	public String populate() {

		listaProvincias = new ArrayList<Option>();
		listaProvincias.add(new Option(1, "Madrid"));
		listaProvincias.add(new Option(2, "Murcia"));
		listaProvincias.add(new Option(3, "Salamanca"));
		
		multiList = new ArrayList<String>();
		multiList.add("Opci—n 1");
		multiList.add("Opci—n 2");
		multiList.add("Opci—n 3");
		
		multi = new String[]{"Opci—n 1"};
		opcionSimple = true;
		
		return "populate";
	}
	
	/**
	 * MŽtodo execute
	 */
	public String execute() {
		return SUCCESS;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the listaProvincias
	 */
	public ArrayList<Option> getListaProvincias() {
		return listaProvincias;
	}

	/**
	 * @param listaProvincias the listaProvincias to set
	 */
	public void setListaProvincias(ArrayList<Option> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	/**
	 * @return the multi
	 */
	public String[] getMulti() {
		return multi;
	}

	/**
	 * @param multi the multi to set
	 */
	public void setMulti(String[] multi) {
		this.multi = multi;
	}

	/**
	 * @return the multiList
	 */
	public ArrayList<String> getMultiList() {
		return multiList;
	}

	/**
	 * @param multiList the multiList to set
	 */
	public void setMultiList(ArrayList<String> multiList) {
		this.multiList = multiList;
	}

	/**
	 * @return the opcionSimple
	 */
	public Boolean getOpcionSimple() {
		return opcionSimple;
	}

	/**
	 * @param opcionSimple the opcionSimple to set
	 */
	public void setOpcionSimple(Boolean opcionSimple) {
		this.opcionSimple = opcionSimple;
	}
	
	


}
