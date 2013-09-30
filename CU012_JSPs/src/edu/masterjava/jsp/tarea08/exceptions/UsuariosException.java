/**
 * 
 */
package edu.masterjava.jsp.tarea08.exceptions;

/**
 * 
 * Excepcion de login
 * 
 * @author carloshernandezarques
 * 
 */
public class UsuariosException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String ERROR_OBTENER_USUARIO = "error.usuarios.obtenerusuario";
	public static final String ERROR_CREA_USUARIO_CODE = "error.usuarios.creausuario";

	private String code;

	public UsuariosException(String code) {
		super();
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
