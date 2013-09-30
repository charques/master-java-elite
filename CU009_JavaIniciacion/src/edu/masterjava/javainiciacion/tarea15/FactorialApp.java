/**
 * 
 */
package edu.masterjava.javainiciacion.tarea15;

/**
 * 
 * Defina una clase Factorial, que permita calcular el factorial de un nœmero entero; utilice un
 * algoritmo recursivo. Agregue una segunda funci—n que lo calcule con un bucle for. Probar
 * ambas funciones.
 * 
 * @author carloshernandezarques
 *
 */
public class FactorialApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numero = 10;
		
		int resultado1 = Factorial.factorialRecur(numero);
		System.out.println("FactorialRecur(" + numero + ") = " + resultado1);
		int resultado2 = Factorial.factorialItera(numero);
		System.out.println("FactorialItera(" + numero + ") = " + resultado2);
		
	}

}
