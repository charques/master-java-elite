package edu.masterjava.javainiciacion.tarea03;

/**
 * 
 * Calcular si un a�o, recibido como argumento en la llamada al programa, es bisiesto. La regla
 * para saber si un a�o es bisiesto, es que sea divisible por 4, excepto que si es divisible por
 * 100 lo sea tambi�n por 400. Realice la comprobaci�n mediante el operador m�dulo.
 * 
 * @author carloshernandezarques
 *
 */
public class AnioBisiestoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int anio = 0;
		
		// Transforma el argumento de entrada a int
		try {
			anio = Integer.parseInt(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.err.print("�Has introducido un a�o? no creo... :(");
			System.exit(1);
		}
		catch(NumberFormatException e) {
			System.err.print(args[0] + " no es un a�o :(");
			System.exit(1);
		}
		
		// Valida que el a�o sea mayor que 0
		if(anio <= 0) {
			System.err.print("Un a�o negativo?? :(");
			System.exit(1);
		}
		
		// Si el a�o es correcto, comprueba si el anio es bisiesto
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			System.out.println("El a�o " + anio + " es bisiesto.");
		}
		else {
			System.out.println("El a�o " + anio + " no es bisiesto.");
		}
		System.exit(0);
	}
	
}
