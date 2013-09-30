package edu.masterjava.ejb.tarea01;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class StringsBean
 */
@Stateless
public class StringsBean implements StringsBeanRemote, StringsBeanLocal {

	@Resource
	private SessionContext ctx;

	@Override
	public String convertirMayusculas(String value) {
		return value.toUpperCase();
	}

}
