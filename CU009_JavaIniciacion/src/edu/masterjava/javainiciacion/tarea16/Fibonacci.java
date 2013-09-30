/**
 * 
 */
package edu.masterjava.javainiciacion.tarea16;

/**
 * 
 * Clase que implementa el calculo de la sucesi—n de fibonacci
 * 
 * @author carloshernandezarques
 *
 */
public class Fibonacci {
	
	/**
	 * MŽtodo recursivo para el c‡lculo del nœmero de fibonacci de un 
	 * nœmero pasado como par‡metro.
	 * @param numero
	 * @return
	 */
	public static long fibonacci(long numero) {
		// Caso base
		if((numero == 0) || (numero == 1)) {
			return numero;
		}
		else { // Paso recursivo
			return fibonacci(numero - 1) + fibonacci(numero - 2);
		}
	}
}
