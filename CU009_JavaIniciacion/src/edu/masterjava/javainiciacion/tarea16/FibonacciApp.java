/**
 * 
 */
package edu.masterjava.javainiciacion.tarea16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Escriba una clase Fibonacci con un método recursivo capaz de calcular el número de
 * fibonacci de un entero. El número de fibonacci se define así:
 * • 1 para el número 1
 * • 2 para el número 2
 * • la suma de los números de fibonacci de sus dos anteriores para el resto
 * 
 * @author carloshernandezarques
 *
 */
public class FibonacciApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)) ;
		String inputData = null;
		long numero = 0;

		do {
			System.out.println("Calculo del número de Fibonacci de un entero!!!!");
			System.out.print("Introduce un entero : ");
			
			// Captura un entero de teclado
			try {
				inputData = inputReader.readLine();
			}
			catch(IOException e) {
				System.err.println("Error leyendo la entrada de teclado") ;
				System.exit(1);
			}
			
			// Transforma la entrada en long
			try {
				numero = Integer.parseInt(inputData);
			}
			catch(NumberFormatException e) {
				// Si el usuario no introduce un entero, fuerza a interoducir otro valor.
				inputData = "";
			}
		} while (inputData.length() == 0);
	
		long resultado = Fibonacci.fibonacci(numero);

		System.out.println("Fibonacci (" + numero + ") = " + resultado);
		
		System.exit(0);
	}
}
