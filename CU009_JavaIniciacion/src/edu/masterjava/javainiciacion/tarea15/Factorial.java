/**
 * 
 */
package edu.masterjava.javainiciacion.tarea15;

/**
 * 
 * Clase que implementa m�todos para el calculo factorial
 * 
 * @author carloshernandezarques
 *
 */
public class Factorial {

	/**
	 * M�todo recursivo para el c�lculo del factorial de un n�mero.
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
	 * M�todo iterativo para el c�lculo del factorial de un n�mero.
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
