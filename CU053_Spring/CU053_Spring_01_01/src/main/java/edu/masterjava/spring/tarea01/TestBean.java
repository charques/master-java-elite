package edu.masterjava.spring.tarea01;

public class TestBean {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("El mensaje : " + message);
	}

	public void init() {
		System.out.println("TestBean init.");
	}

	public void destroy() {
		System.out.println("TestBean destroy.");
	}
}
