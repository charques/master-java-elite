package edu.masterjava.spring.tarea02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.masterjava.spring.tarea02.beans.ScopeTestBean;


public class MainSingleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"core-configuration-singleton.xml");

		ScopeTestBean obj1 = (ScopeTestBean) context.getBean("testBean");
		System.out.println("bean1 " + obj1.getValueString());
		obj1.setValue(1);
		System.out.println("bean1 " + obj1.getValueString());
				
		System.out.println("----------------");
		
		ScopeTestBean obj2 = (ScopeTestBean) context.getBean("testBean");
		System.out.println("bean2 " + obj2.getValueString());
		obj2.setValue(2);
		System.out.println("bean2 " + obj2.getValueString());
		
	}

}
