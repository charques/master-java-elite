package edu.masterjava.ejb.tarea01;

import javax.ejb.Remote;

@Remote
public interface StringsBeanRemote {

	/**
	 * Conviente una cadena a mayusculas.
	 * @param value
	 * @return
	 */
    public String convertirMayusculas(String value);
}
