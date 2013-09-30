/**
 * 
 */
package edu.masterjava.javainiciacion.tarea11;

/**
 * Clase que implementa un libro.
 * 
 * @author carloshernandezarques
 *
 */
public class Libro {

	private String titulo;
	
	private String autor;
	
	private String anioPubli;
	
	private String editorial;
	
	/**
	 * Constructor
	 */
	public Libro() {
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
	 * @return the anioPubli
	 */
	public String getAnioPubli() {
		return anioPubli;
	}

	/**
	 * @param anioPubli the anioPubli to set
	 */
	public void setAnioPubli(String anioPubli) {
		this.anioPubli = anioPubli;
	}

	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/**
	 * Representaci—n de libro.
	 */
	public String toString() {
		return this.getTitulo() + " - " + this.getAutor() + " - " + this.getAnioPubli() + " - " + this.getEditorial();
	}
	
	

}
