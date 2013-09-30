/**
 * 
 */
package edu.masterjava.javainiciacion.tarea11;

/**
 * 
 * Defina una clase libro que pueda ser utilizada para representar los libros que hay en una
 * biblioteca. Suponga que cada libro tiene los siguientes atributos:
 * 1.1.1.1. Título
 * 1.1.1.2. Autor
 * 1.1.1.3. Año de publicación
 * 1.1.1.4. Editorial
 * Escriba un método main donde creará dos objetos de la clase libro, de valor a las
 * propiedades de los objeto libro, y al final, muestre los datos de cada uno de ellos.
 * 
 * @author carloshernandezarques
 *
 */
public class LibrosApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Libro libro1 = new Libro();
		libro1.setTitulo("Java 2: Curso de programación");
		libro1.setAutor("Fco. Javier Ceballos");
		libro1.setAnioPubli("2010");
		libro1.setEditorial("Ra-Ma");

		Libro libro2 = new Libro();
		libro2.setTitulo("XML: Guia práctica");
		libro2.setAutor("Óscar Gonzalez");
		libro2.setAnioPubli("2005");
		libro2.setEditorial("Anaya");
		
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
	}

}
