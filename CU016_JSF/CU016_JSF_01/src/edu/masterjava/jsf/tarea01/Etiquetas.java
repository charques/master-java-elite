package edu.masterjava.jsf.tarea01;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class Etiquetas implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String password;
	
	private String hidden = "hiddenValue";
	
	private String texto;
	
	private boolean actualizar;
	
	private String[] listaValores;
	
	private String[] listaOpciones;
	
	private String[] listaRadios;
	
	private String[] listaSelect;
	
	private String radioOpcion;
	
	private String selectOpcion;
	
	public String[] getListaValoresValue() {
		 
		listaValores = new String[5];
		listaValores[0] = "valor 1";
		listaValores[1] = "valor 2";
		listaValores[2] = "valor 3";
		listaValores[3] = "valor 4";
		listaValores[4] = "valor 5";
 
		return listaValores;
	}
 
	public String getListaValoresInString() {
		return Arrays.toString(listaValores);
	}
	
	public String[] getListaOpcionesValue() {
		 
		listaOpciones = new String[5];
		listaOpciones[0] = "opci—n 1";
		listaOpciones[1] = "opci—n 2";
		listaOpciones[2] = "opci—n 3";
		listaOpciones[3] = "opci—n 4";
		listaOpciones[4] = "opci—n 5";
 
		return listaOpciones;
	}
 
	public String getListaOpcionesInString() {
		return Arrays.toString(listaOpciones);
	}
	
	public String[] getListaRadiosValue() {
		 
		listaRadios = new String[2];
		listaRadios[0] = "op 1";
		listaRadios[1] = "op 2";
 
		return listaRadios;
	}
	
	public String[] getListaSelectValue() {
		 
		listaSelect = new String[3];
		listaSelect[0] = "select 1";
		listaSelect[1] = "select 2";
		listaSelect[2] = "select 3";
 
		return listaSelect;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the actualizar
	 */
	public boolean isActualizar() {
		return actualizar;
	}

	/**
	 * @param actualizar the actualizar to set
	 */
	public void setActualizar(boolean actualizar) {
		this.actualizar = actualizar;
	}

	/**
	 * @return the listaValores
	 */
	public String[] getListaValores() {
		return listaValores;
	}

	/**
	 * @param listaValores the listaValores to set
	 */
	public void setListaValores(String[] listaValores) {
		this.listaValores = listaValores;
	}

	/**
	 * @return the listaOpciones
	 */
	public String[] getListaOpciones() {
		return listaOpciones;
	}

	/**
	 * @param listaOpciones the listaOpciones to set
	 */
	public void setListaOpciones(String[] listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	/**
	 * @return the listaRadios
	 */
	public String[] getListaRadios() {
		return listaRadios;
	}

	/**
	 * @param listaRadios the listaRadios to set
	 */
	public void setListaRadios(String[] listaRadios) {
		this.listaRadios = listaRadios;
	}

	/**
	 * @return the listaSelect
	 */
	public String[] getListaSelect() {
		return listaSelect;
	}

	/**
	 * @param listaSelect the listaSelect to set
	 */
	public void setListaSelect(String[] listaSelect) {
		this.listaSelect = listaSelect;
	}

	/**
	 * @return the radioOpcion
	 */
	public String getRadioOpcion() {
		return radioOpcion;
	}

	/**
	 * @param radioOpcion the radioOpcion to set
	 */
	public void setRadioOpcion(String radioOpcion) {
		this.radioOpcion = radioOpcion;
	}

	/**
	 * @return the selectOpcion
	 */
	public String getSelectOpcion() {
		return selectOpcion;
	}

	/**
	 * @param selectOpcion the selectOpcion to set
	 */
	public void setSelectOpcion(String selectOpcion) {
		this.selectOpcion = selectOpcion;
	}
	
	
	

}