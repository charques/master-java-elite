package edu.masterjava.spring.tarea02.beans;

public class ScopeTestBean {
	private int value = 0;

	public void setValue(int valor) {
		this.value = valor;
		System.out.println("set value : " + String.valueOf(value));
	}

	public String getValueString() {
		return "get value : " + String.valueOf(value);
	}
}
