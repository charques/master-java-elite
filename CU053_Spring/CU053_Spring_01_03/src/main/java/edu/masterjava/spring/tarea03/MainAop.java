package edu.masterjava.spring.tarea03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.masterjava.spring.tarea03.beans.ExampleBean;


public class MainAop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"core-configuration.xml");

		ExampleBean bean = (ExampleBean) context.getBean("exampleBean");

		System.out.println("-------------------------");
		bean.printContent();		
		System.out.println("-------------------------");
		try {
			bean.throwIllegalArgumentException();
		} catch (Exception e) {

		}		
	}

}
