/**
 * 
 */
package edu.masterjava.servlets.tarea07.model;

import java.io.Serializable;

/**
 * 
 * Item del configuracion
 * 
 * @author carloshernandezarques
 * 
 */
public class Config implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String descripcion;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
