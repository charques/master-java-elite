/**
 * 
 */
package edu.masterjava.javaintermedio.tarea03;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * Tarea 3. Crear un programa java que lea un fichero y lo copie en otro fichero.
 * Modificar el ejemplo paro que haga lo mismo, pero transformando cada letra a
 * mayœsculas en el fichero de salida.
 * 
 * @author carloshernandezarques
 * 
 */
public class CopiarFicherosApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileNameOrigen = "textFile1.txt";
		String fileNameDestino = "textFile2.txt";
		if (args.length == 2) {
			fileNameOrigen = args[0];
			fileNameDestino = args[1];
		}

		FileCopier fileCopier = new FileCopier(fileNameOrigen, fileNameDestino);
		try {
			// copia el fichero en minusculas
			fileCopier.copy(false);
			
			// copia el fichero en mayuscules
			fileCopier.copy(true);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + " en el directorio especificado.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());		
		}

	}

}
