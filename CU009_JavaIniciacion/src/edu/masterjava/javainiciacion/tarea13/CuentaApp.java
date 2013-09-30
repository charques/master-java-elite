/**
 * 
 */
package edu.masterjava.javainiciacion.tarea13;

import java.text.DecimalFormat;

/**
 * 
 * Representar una cuenta corriente, con el concepto saldo y las tres operaciones siguientes:
 * ¥ getSaldo: devuelve el saldo de la cuenta (puede ser negativo).
 * ¥ imposici—n (cantidad): ingresa en la cuenta una cantidad de dinero.
 * ¥ reintegro (cantidad): saca de la cuenta una determinada cantidad de dinero.
 * 
 * Escriba un programa para probar la clase CuentaCorriente y sus metodos.
 * 
 * @author carloshernandezarques
 *
 */
public class CuentaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CuentaCorriente cuenta = new CuentaCorriente(1000.0);
		System.out.println("El saldo de la cuenta es: " + transformToEuros(cuenta.getSaldo()));
		cuenta.imposicion(234.78);
		System.out.println("El saldo de la cuenta es: " + transformToEuros(cuenta.getSaldo()));
		cuenta.reintegro(1.50);
		System.out.println("El saldo de la cuenta es: " + transformToEuros(cuenta.getSaldo()));
		cuenta.reintegro(126.42);
		System.out.println("El saldo de la cuenta es: " + transformToEuros(cuenta.getSaldo()));
		cuenta.reintegro(1229.32);
		System.out.println("El saldo de la cuenta es: " + transformToEuros(cuenta.getSaldo()));
		cuenta.imposicion(1232.56);
		System.out.println("El saldo de la cuenta es: " + transformToEuros(cuenta.getSaldo()));
	}
	
	private static String transformToEuros(double valor) {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(valor) + " Û";
	}

}
