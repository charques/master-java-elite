/**
 * 
 */
package edu.masterjava.javaintermedio.tarea07;

/**
 * 
 * Excepcion
 * 
 * @author carloshernandezarques
 *
 */
public class WebRequestException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static final int CODE_ERROR_BAD_REQUEST = 400;
	public static final int CODE_ERROR_NOT_FOUND = 404;
	public static final int CODE_ERROR_INTERNAL_SERVER_ERROR = 500;
	
	public static final String MESSAGE_ERROR_BAD_REQUEST = "Error: petici—n incorrecta.\n";
	public static final String MESSAGE_ERROR_INTERNAL_SERVER_ERROR = "Error: error interno.\n";
	public static final String MESSAGE_ERROR_NOT_FOUND = "Error: p‡gina no encontrada.\n";
	
	/**
	 * Codigo de excepcion
	 */
	private int code;

	/**
	 * Constructor
	 * @param code
	 * @param message
	 */
	public WebRequestException(int code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
