package edu.masterjava.javainiciacion.tarea05;

/**
 * 
 * Escriba un programa que calcule la distancia recorrida por un m—vil (Et) que se mueve a
 * velocidad constante de 3.5 m/s y que ha recorrido un espacio inicial (ei) de 12.3 m en un
 * tiempo de t segundos. El valor de t se introducir‡ como argumento en la llamada del
 * programa.
 * 
 * Et = v * t + ei
 * 
 * @author carloshernandezarques
 *
 */
public class CalcularDistRecorridaApp {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Espacio recorrido
		float et = 0;
		
		// Tiempo
		float t = 0;
		
		// Transforma el argumento de entrada a int
		try {
			t = Float.parseFloat(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.err.print("ÀHas introducido el tiempo en segundos? no creo... :(");
			System.exit(1);
		}
		catch(NumberFormatException e) {
			System.err.print(args[0] + " no es v‡lido :(");
			System.exit(1);
		}
		
		// Valida que el tiempo sea mayor que 0
		if(t <= 0) {
			System.err.print("Tiempo negativo?? :(");
			System.exit(1);
		}
		
		// Si el tiempo es correcta, realiza el c‡lculo
		et = CalculaET.calcularEspacioRecorrido(t);
		
		System.out.print("El espacio recorrido en " + t + " segundos es " + et + " metros");
		System.exit(0);
	}

}
