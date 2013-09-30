package edu.masterjava.javainiciacion.tarea03;

/**
 * 
 * Calcular si un año, recibido como argumento en la llamada al programa, es bisiesto. La regla
 * para saber si un año es bisiesto, es que sea divisible por 4, excepto que si es divisible por
 * 100 lo sea también por 400. Realice la comprobación mediante el operador módulo.
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
			System.err.print("¿Has introducido un año? no creo... :(");
			System.exit(1);
		}
		catch(NumberFormatException e) {
			System.err.print(args[0] + " no es un año :(");
			System.exit(1);
		}
		
		// Valida que el año sea mayor que 0
		if(anio <= 0) {
			System.err.print("Un año negativo?? :(");
			System.exit(1);
		}
		
		// Si el año es correcto, comprueba si el anio es bisiesto
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			System.out.println("El año " + anio + " es bisiesto.");
		}
		else {
			System.out.println("El año " + anio + " no es bisiesto.");
		}
		System.exit(0);
	}
	
}
