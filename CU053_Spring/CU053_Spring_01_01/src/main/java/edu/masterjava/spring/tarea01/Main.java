package edu.masterjava.spring.tarea01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"core-configuration.xml");

		TestBean obj = (TestBean) context.getBean("testBean");
		obj.getMessage();
		context.registerShutdownHook();
	}

}
