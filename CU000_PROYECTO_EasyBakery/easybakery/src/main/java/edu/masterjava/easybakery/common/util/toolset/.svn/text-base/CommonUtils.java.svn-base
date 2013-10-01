package edu.masterjava.easybakery.common.util.toolset;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Utilidades.
 * 
 * @author carloshernandezarques
 */
public class CommonUtils {

	/**
	 * Conviente un string con formato dd/MM/yyyy e Date.
	 * @param stringDate
	 * @return
	 */
	public static Date stringToDate(String stringDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return format.parse(stringDate);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * Comprueba si una lista est‡ vac’a.
	 * @param list
	 * @return
	 */
	public static <T> boolean isNullEmpty(List<T> list) {
		if(list == null) 
			return true;
		if(list.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Comprueba si una lista tiene elementos.
	 * @param list
	 * @return
	 */
	public static <T> boolean hasElements(List<T> list) {
		if(list == null) 
			return false;
		if(list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Comprueba si una lista tiene elementos.
	 * @param list
	 * @return
	 */
	public static <T> boolean hasElements(Set<T> list) {
		if(list == null) 
			return false;
		if(list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Conviente un String en un Double.
	 * Si hay un error de formato, devuelve 0.
	 * @param value
	 * @return
	 */
	public static Double stringToDouble(String value) {
		try {
			return Double.valueOf(value);
		}
		catch(NumberFormatException e) {
			return 0d;
		}
	}
	
	/**
	 * Conviente un String en un Integer.
	 * Si hay un error de formato, devuelve 0.
	 * @param value
	 * @return
	 */
	public static Integer stringToInteger(String value) {
		try {
			return Integer.valueOf(value);
		}
		catch(NumberFormatException e) {
			return 0;
		}
	}
	
	/**
	 * Conviente un Double en un String.
	 * Si hay un error de formato, devuelve cadena vacia.
	 * @param value
	 * @return
	 */
	public static String doubleToString(Double value) {
		try {
			return String.valueOf(value);
		}
		catch(Exception e) {
			return "";
		}
	}
	
	/**
	 * Conviente un Integer en un String.
	 * Si hay un error de formato, devuelve cadena vacia.
	 * @param value
	 * @return
	 */
	public static String integerToString(Integer value) {
		try {
			return String.valueOf(value);
		}
		catch(Exception e) {
			return "";
		}
	}
	
	/**
	 * Conviente un BigInteger en un String.
	 * Si hay un error de formato, devuelve cadena vacia.
	 * @param value
	 * @return
	 */
	public static String bigDecimalToString(BigDecimal value) {
		try {
			return String.valueOf(value);
		}
		catch(Exception e) {
			return "";
		}
	}
}
