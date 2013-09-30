package edu.masterjava.spring.tarea02;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class StringsBean
 */
@Stateless
public class MathBean implements MathBeanRemote {

	@Override
	public int sumar(int value1, int value2) {
		return value1 + value2;
	}

	@Override
	public int restar(int value1, int value2) {
		return value1 - value2;
	}

}
