/**
 * 
 */
package edu.masterjava.javainiciacion.tarea08;

import java.util.regex.Pattern;

/**
 * 
 * Escriba un programa que declare dos variables de tipo String inicializadas con dos valores
 * literales. Compruebe si son iguales, calcule la longitud de ambas cadenas de caracteres,
 * sume las cadenas y calcule la longitud del resultado. Convierta la suma a mayœsculas y
 * visualice las cadenas. Compruebe si dentro de las cadenas existe el literal ÒPruebaÓ ,
 * mostrar la posici—n en caso de que se encuentre.
 * 
 * @author carloshernandezarques
 *
 */
public class StringsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// inicializaci—n
		String cadena1 = "Cadena";
		String cadena2 = "Prueba";
		
		// comprueba si son iguales
		boolean iguales = cadena1.equals(cadena2);
		
		//(iguales) ? System.out.println("Son iguales!!") : System.out.println("No son iguales!!"); 
		
		if(iguales) 
			System.out.println("Son iguales!!");
		else 
			System.out.println("No son iguales!!");
		
		// calcula la longitud de las cadenas
		int long1 = cadena1.length();
		int long2 = cadena1.length();
		System.out.println("La longitud de '" + cadena1 + "' es "+ long1);
		System.out.println("La longitud de '" + cadena2 + "' es "+ long2);
		
		// calcula longitud de la suma
		String suma = cadena1 + cadena2;
		int long3 = suma.length();
		System.out.println("La longitud de '" + suma + "' es "+ long3);
		
		// convierte la suma a mayusculas
		String sumaM = suma.toUpperCase();
		System.out.println("cadena1 : '" + cadena1 + "', cadena2 : '" + cadena2 + "', suma : '" + sumaM + "'");
		
		// comprueba si existe el literal "Prueba"
		int indice = suma.lastIndexOf("Prueba");
		
		if(indice >= 0) {
			System.out.println("La posici—n de la cadena 'Prueba' es : " + indice);
		}
		else {
			System.out.println("No se ha encontrado la cadena 'Prueba'");
		}
		
	}

}
