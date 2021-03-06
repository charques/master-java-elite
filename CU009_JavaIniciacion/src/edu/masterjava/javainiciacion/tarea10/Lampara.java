package edu.masterjava.javainiciacion.tarea10;

/**
 * Clase que implementa una lampara
 * 
 * @author carloshernandezarques
 *
 */
public class Lampara {

	private boolean encendida = false;
	
	public Lampara() {
		
	}
	
	/**
	 * Enciende la lampara.
	 */
	public void encender() {
		this.encendida = true;
	}
	
	/**
	 * Apaga la lampara.
	 */
	public void apagar() {
		this.encendida = false;
	}
	
	/**
	 * @return the encendida
	 */
	public boolean estaEncendida() {
		return encendida;
	}
	
	/**
	 * Representación de la lámpara.
	 */
	public String toString() {
		if(estaEncendida()) 
			return "encendida";
		return "apagada";
	}
}
