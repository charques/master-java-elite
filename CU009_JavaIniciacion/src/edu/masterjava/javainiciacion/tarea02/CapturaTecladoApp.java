package edu.masterjava.javainiciacion.tarea02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Crear una aplicaci—n que muestre en pantalla un texto le’do del teclado.
 * 
 * @author carloshernandezarques
 *
 */
public class CapturaTecladoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)) ;
		String inputData = null;

		do {
			System.out.print("ÀComo te llamas? : ");
			
			try {
				inputData = inputReader.readLine();
			}
			catch(IOException e) {
				System.err.println("Error leyendo la entrada de teclado") ;
				System.exit(1);
			}
		} while (inputData.length() == 0);
		
		if((inputData != null) && (inputData.length() > 0)) {
			System.out.println("");
			System.out.println("Bienvenido " + inputData + "!!!") ;
			System.exit(0);
		}
	}

}
