package edu.masterjava.jsp.comun;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {

	/**
	 * Convierte un String en Integer
	 * 
	 * @param value
	 * @return
	 */
	public static Integer convertirStringToInteger(String value) {
		Integer intValue;
		try {
			intValue = Integer.valueOf(value);
		} catch (Exception e) {
			return null;
		}
		return intValue;
	}

	/**
	 * Comprueba si una cadena en nula o vacia.
	 * 
	 * @param value
	 * @return
	 */
	public static boolean esNuloVacio(String value) {
		if ((value != null) && (value.length() > 0)) {
			return false;
		}
		return true;
	}

	/**
	 * Genera string aleatorio
	 * @param numChars
	 * @return
	 */
	public static String generateRandomString(int numChars) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < numChars; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * Encripta una password.
	 * @param password
	 * @return
	 */
	public static String encriptarPassword(String password) {
		MessageDigest mdEnc;
		String passwordMd5 = null;
		try {
			mdEnc = MessageDigest.getInstance("MD5");
			mdEnc.update(password.getBytes(), 0, password.length());
			passwordMd5 = new BigInteger(1, mdEnc.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// no hace nada
		}

		return passwordMd5;
	}

}
