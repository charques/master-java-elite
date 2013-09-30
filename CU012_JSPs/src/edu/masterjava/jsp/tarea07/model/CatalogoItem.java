/**
 * 
 */
package edu.masterjava.jsp.tarea07.model;

import java.io.Serializable;

/**
 * 
 * Item del catalogo
 * 
 * @author carloshernandezarques
 * 
 */
public class CatalogoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String titulo;

	private String autor;

	private Integer idSoporte;
	
	private String descripSoporte;
	
	private Integer idTipo;
	
	private String descripTipo;
	
	private Integer anio;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the idSoporte
	 */
	public Integer getIdSoporte() {
		return idSoporte;
	}

	/**
	 * @param idSoporte the idSoporte to set
	 */
	public void setIdSoporte(Integer idSoporte) {
		this.idSoporte = idSoporte;
	}

	/**
	 * @return the descripSoporte
	 */
	public String getDescripSoporte() {
		return descripSoporte;
	}

	/**
	 * @param descripSoporte the descripSoporte to set
	 */
	public void setDescripSoporte(String descripSoporte) {
		this.descripSoporte = descripSoporte;
	}

	/**
	 * @return the idTipo
	 */
	public Integer getIdTipo() {
		return idTipo;
	}

	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	/**
	 * @return the descripTipo
	 */
	public String getDescripTipo() {
		return descripTipo;
	}

	/**
	 * @param descripTipo the descripTipo to set
	 */
	public void setDescripTipo(String descripTipo) {
		this.descripTipo = descripTipo;
	}

	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	
}
