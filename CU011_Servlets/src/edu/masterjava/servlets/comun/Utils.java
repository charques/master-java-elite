package edu.masterjava.servlets.comun;

public class Utils {

	/**
	 * Convierte un String en Integer
	 * @param value
	 * @return
	 */
	public static Integer convertirStringToInteger(String value) {
		Integer intValue;
		try {
			intValue = Integer.valueOf(value);
		}
		catch(Exception e) {
			return null;
		}
		return intValue;
	}
}
