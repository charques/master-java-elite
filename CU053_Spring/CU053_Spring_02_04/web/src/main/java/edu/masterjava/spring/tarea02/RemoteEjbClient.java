package edu.masterjava.spring.tarea02;

import javax.naming.NamingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoteEjbClient {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		ApplicationContext springCtx = new ClassPathXmlApplicationContext("core-configuration.xml");
		MathBeanRemote mathBean = (MathBeanRemote) springCtx.getBean("mathBean");
		
		int suma = mathBean.sumar(1, 1);
		System.out.println("suma : " + suma);
		
		int resta = mathBean.restar(5, 3);
		System.out.println("resta : " + resta);
	}
	
}
