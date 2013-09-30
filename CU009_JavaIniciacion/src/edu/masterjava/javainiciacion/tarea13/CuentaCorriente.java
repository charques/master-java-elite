/**
 * 
 */
package edu.masterjava.javainiciacion.tarea13;

/**
 * Clase que implementa una cuenta corriente.
 * 
 * @author carloshernandezarques
 *
 */
public class CuentaCorriente {

	private double saldo;
	
	/**
	 * Constructor.
	 */
	public CuentaCorriente() {
	}
	
	/**
	 * Constructor.
	 */
	public CuentaCorriente(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Ingresa en la cuenta una cantidad de dinero.
	 * @param cantidad
	 * @return
	 */
	public double imposicion(double cantidad) {
		this.saldo += cantidad;
		return this.saldo;
	}
	
	/**
	 * Saca de la cuenta una determinada cantidad de dinero.
	 * @param cantidad
	 * @return
	 */
	public double reintegro(double cantidad) {
		this.saldo -= cantidad;
		return this.saldo;
	}
	
}
