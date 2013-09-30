package edu.masterjava.spring.tarea02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.masterjava.spring.tarea02.beans.FactoryTestBean;


public class MainFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"core-configuration-factory.xml");

		FactoryTestBean obj1 = (FactoryTestBean) context.getBean("testBean");
		System.out.println("bean1 " + System.identityHashCode(obj1));
		
		System.out.println("----------------");
		
		FactoryTestBean obj2 = (FactoryTestBean) context.getBean("testBean");
		System.out.println("bean2 " + System.identityHashCode(obj2));
		
	}

}
