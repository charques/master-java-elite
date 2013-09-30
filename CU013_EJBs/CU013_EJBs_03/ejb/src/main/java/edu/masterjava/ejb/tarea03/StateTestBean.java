package edu.masterjava.ejb.tarea03;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class StringsBean
 */
@Stateful
//@Stateless
public class StateTestBean implements StateTestBeanRemote, StateTestBeanLocal {

	@Resource
	private SessionContext ctx;
	
	private int value;

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}
	
}
