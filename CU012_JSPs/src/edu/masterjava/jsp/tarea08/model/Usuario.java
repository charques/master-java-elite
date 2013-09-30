/**
 * 
 */
package edu.masterjava.jsp.tarea08.model;

import java.io.Serializable;

/**
 * 
 * Usuario
 * 
 * @author carloshernandezarques
 * 
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String passwordMd5;

	private String nombre;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the passwordMd5
	 */
	public String getPasswordMd5() {
		return passwordMd5;
	}

	/**
	 * @param passwordMd5
	 *            the passwordMd5 to set
	 */
	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}

}
