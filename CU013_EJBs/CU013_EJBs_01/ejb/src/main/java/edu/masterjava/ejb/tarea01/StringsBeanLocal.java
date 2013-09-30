package edu.masterjava.ejb.tarea01;

import javax.ejb.Local;

@Local
public interface StringsBeanLocal {

	/**
	 * Conviente una cadena a mayusculas.
	 * @param value
	 * @return
	 */
    public String convertirMayusculas(String value);
}
