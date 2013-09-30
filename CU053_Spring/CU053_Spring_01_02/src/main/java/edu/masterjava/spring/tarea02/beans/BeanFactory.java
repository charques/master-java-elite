package edu.masterjava.spring.tarea02.beans;


public class BeanFactory {
	
	private static FactoryTestBean testBean = null;
	private static BeanFactory beanFactory= new BeanFactory();
	
	public  FactoryTestBean createTestBean() {
		// Crea el singleton
		if(testBean == null) {
			testBean = new FactoryTestBean();
		}
		
		return testBean;
	}
	
	public static BeanFactory createInstance(){
		return beanFactory;
	}
	
}
