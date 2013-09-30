package edu.masterjava.javainiciacion.tarea07;

public class Complejo {

	private double real;
	private double imag;

	public Complejo() {
		real = 0.0;
		imag = 0.0;
	}

	public Complejo(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	/**
	 * Suma de nœmeros complejos.
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Complejo suma(Complejo c1, Complejo c2) {
		double x = c1.real + c2.real;
		double y = c1.imag + c2.imag;
		return new Complejo(x, y);
	}
	
	/**
	 * Resta de nœmeros complejos.
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Complejo resta(Complejo c1, Complejo c2) {
		double x = c1.real - c2.real;
		double y = c1.imag - c2.imag;
		return new Complejo(x, y);
	}

	/**
	 * Producto de nœmeros complejos.
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Complejo producto(Complejo c1, Complejo c2) {
		double x = c1.real * c2.real - c1.imag * c2.imag;
		double y = c1.real * c2.imag + c1.imag * c2.real;
		return new Complejo(x, y);
	}
	
	/**
	 * Cociente de nœmeros complejos.
	 * @param c1
	 * @param c2
	 * @return
	 * @throws ExcepcionDivisionCero
	 */
	public static Complejo cociente(Complejo c1, Complejo c2) throws ExcepcionDivisionCero{
	     double temp;
	     double x;
	     double y;
	     
	     temp=c2.real*c2.real+c2.imag*c2.imag;
	     if(temp == 0){
	          throw new ExcepcionDivisionCero("Divisi—n entre cero");
	     }
	     else{
	          x=(c1.real*c2.real+c1.imag*c2.imag)/temp;
	          y=(c1.imag*c2.real-c1.real*c2.imag)/temp;
	     }
	     return new Complejo(x, y);
	  }

	/**
	 * Muestra el nœmero complejo como String.
	 */
	public String toString() {
		if (imag > 0) {
			return new String((double) Math.round(100 * real) / 100 + " + "
					+ (double) Math.round(100 * imag) / 100 + "*i");
		} else {
			return new String((double) Math.round(100 * real) / 100 + " - "
					+ (double) Math.round(-100 * imag) / 100 + "*i");
		}

	}
}