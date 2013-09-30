package edu.masterjava.spring.tarea02;

import javax.ejb.Remote;

@Remote
public interface MathBeanRemote {

	/**
	 * Suma 2 enteros
	 * @param value1
	 * @param value2
	 * @return
	 */
    public int sumar(int value1, int value2);
    
    /**
     * Resta 2 enteros.
     * @param value1
     * @param value2
     * @return
     */
    public int restar(int value1, int value2);
}
