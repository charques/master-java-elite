/**
 * 
 */
package edu.masterjava.servlets.tarea07.exceptions;

/**
 * 
 * Excepcion de catalogo
 * 
 * @author carloshernandezarques
 *
 */
public class CatalogoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static final String ERROR_VALIDACION = "error validacion";
	public static final String ERROR_SQL = "error sql";

	public CatalogoException(String msg)
	  {
	    super(msg);
	  }
}
