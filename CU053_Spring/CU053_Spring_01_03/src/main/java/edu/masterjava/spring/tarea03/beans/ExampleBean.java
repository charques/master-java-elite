package edu.masterjava.spring.tarea03.beans;

public class ExampleBean {

	private String nombre;
	private String pais;

	/**
	 * Imprime
	 */
	public void printContent() {
		System.out.println(nombre + " - " + pais);		
	}
	
	/**
	 * Lanza una excepcion.
	 */
	public void throwIllegalArgumentException() {
		throw new IllegalArgumentException();
	}
	
	/**
	 * @return Devuelve el atributo nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Fija el valor de nombre al campo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Devuelve el atributo pais.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais Fija el valor de pais al campo pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	
}