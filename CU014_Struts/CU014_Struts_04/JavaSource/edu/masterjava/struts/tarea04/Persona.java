package edu.masterjava.struts.tarea04;

public class Persona extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String edad;

	public Persona() {
		super();
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
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}

	
	
}
