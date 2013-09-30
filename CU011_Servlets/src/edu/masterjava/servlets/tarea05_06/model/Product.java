/**
 * 
 */
package edu.masterjava.servlets.tarea05_06.model;

import java.io.Serializable;

/**
 * 
 * Producto
 * 
 * @author carloshernandezarques
 * 
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nombre;

	private String descripcion;

	private float precio;

	private int unidadesCarro;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the unidadesCarro
	 */
	public int getUnidadesCarro() {
		return unidadesCarro;
	}

	/**
	 * @param unidadesCarro
	 *            the unidadesCarro to set
	 */
	public void setUnidadesCarro(int unidadesCarro) {
		this.unidadesCarro = unidadesCarro;
	}

}
