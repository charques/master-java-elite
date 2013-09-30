package edu.masterjava.ejb.tarea03;

import javax.ejb.Local;

@Local
public interface StateTestBeanLocal {

	/**
	 * @return the value
	 */
	public int getValue();

	/**
	 * @param value the value to set
	 */
	public void setValue(int value);
}
