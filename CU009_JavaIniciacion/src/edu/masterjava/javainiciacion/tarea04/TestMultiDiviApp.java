/**
 * 
 */
package edu.masterjava.javainiciacion.tarea04;

/**
 * 
 * Escriba un programa que declare una variable de tipo entero con el valor de 77. Divida esta
 * variable por 10, vuelva a multiplicarla por 10, e imprima el resultado. Asigne otra vez 77 a
 * la variable y repita el proceso pero multiplicando y dividiendo por 10.0f . Observe las
 * diferencias.
 * 
 * @author carloshernandezarques
 *
 */
public class TestMultiDiviApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int valor = 77;
		
		valor = valor / 10;
		valor = valor * 10;
		
		System.out.println("valor : " + valor);
		
		valor = 77;
		
		valor = (int) (valor / 10.0f);
		valor = (int) (valor * 10.0f);
		
		System.out.println("valor : " + valor);
		System.exit(0);
	}

}
