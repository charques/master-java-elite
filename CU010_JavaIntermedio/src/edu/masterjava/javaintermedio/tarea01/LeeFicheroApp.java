package edu.masterjava.javaintermedio.tarea01;

import java.io.FileNotFoundException;

/**
 * 
 * Tarea 1. Realizar un programa que lea una cadena de texto de un fichero de texto 
 * y la muestre en pantalla.
 * 
 * @author carloshernandezarques
 *
 */
public class LeeFicheroApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "text.txt";
	    String encoding = "UTF-8";
	    if(args.length == 2) {
	    	fileName = args[0];
		    encoding = args[1];
	    }
		
		FileReader fileReader = new FileReader(fileName, encoding);
		try {
			String output = fileReader.read();
			System.out.println(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
