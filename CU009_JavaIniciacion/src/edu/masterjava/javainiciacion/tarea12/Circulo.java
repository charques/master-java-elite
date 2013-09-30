/**
 * 
 */
package edu.masterjava.javainiciacion.tarea12;

/**
 * Clase que implementa un c’rculo.
 * 
 * @author carloshernandezarques
 *
 */
public class Circulo {

	private int x = 0;
	
	private int y = 0;
	
	private double radio = 0;
	
	/**
	 * Constructor 
	 */
	public Circulo() {

	}
	
	/**
	 * Contructor
	 * @param x
	 * @param y
	 * @param radio
	 */
	public Circulo(int pX, int pY, float pRadio) {
		this.x = pX;
		this.y = pY;
		this.radio = pRadio;
	}
	
	/**
	 * çrea de la circunferencia
	 * 
	 * A = pi*r*r
	 * 
	 * @return
	 */
	public double area() {
		if(radio > 0)
		{
			return Math.PI * radio * radio;
		}
		return 0;
	}
	
	/**
	 * Per’metro de la circunferencia
	 * 
	 * P = p*2*r
	 * 
	 * @return
	 */
	public double perimetro() {
		if(radio > 0)
		{
			return Math.PI * 2 * radio;
		}
		return 0;
	}
	
	/**
	 * Representaci—n de c’rculo.
	 */
	public String toString() {
		return "Circulo - x: " + this.getX() + " - y: " + this.getY() + " - radio: " + this.getRadio();
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the radio
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * @param radio the radio to set
	 */
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	

}
