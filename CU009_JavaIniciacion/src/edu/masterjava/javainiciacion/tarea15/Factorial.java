/**
 * 
 */
package edu.masterjava.javainiciacion.tarea15;

/**
 * 
 * Clase que implementa métodos para el calculo factorial
 * 
 * @author carloshernandezarques
 *
 */
public class Factorial {

	/**
	 * Método recursivo para el cálculo del factorial de un número.
	 * @param numero
	 * @return
	 */
	public static int factorialRecur(int numero){
        if (numero <= 1) {
            return 1;
        } 
        else {
            return numero*factorialRecur(numero-1);
        }
	}
	
	/**
	 * Método iterativo para el cálculo del factorial de un número.
	 * @param numero
	 * @return
	 */
	public static int factorialItera(int numero){
        int resultado = 1;
        for(int i = 1; i <= numero; i++) {
        	resultado = resultado*i;
        }
        return resultado;
	}

}
