/**
 * 
 */
package edu.masterjava.javainiciacion.tarea19;

/**
 * 
 * Clase que representa un plato
 * 
 * @author carloshernandezarques
 *
 */
public class Plato {
	
	/**
	 * Nombre del plato.
	 */
	private String nombre;

	/**
	 * Precio del plato.
	 */
	private float precio;
	
	/**
	 * Constructor
	 */
	public Plato(String nombre, float d) {
		this.nombre = nombre;
		this.precio = d;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	
	

}
