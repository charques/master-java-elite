package edu.masterjava.javaintermedio.tarea01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Implementa un lector de ficheros
 * 
 * @author carloshernandezarques
 */
public class FileReader {

	private final String fileName;
	private final String encoding;

	/**
	 * Constructor
	 * 
	 * @param aFileName
	 * @param aEncoding
	 */
	public FileReader(String aFileName, String aEncoding) {
		fileName = aFileName;
		encoding = aEncoding;
	}
	
	/**
	 * Lee el fichero y devuelve el texto.
	 * @return
	 * @throws FileNotFoundException
	 */
	public String read() throws FileNotFoundException {
		
	    StringBuilder text = new StringBuilder();
	    String NL = System.getProperty("line.separator");
	    Scanner scanner = new Scanner(new FileInputStream(fileName), encoding);
	    try {
	      while (scanner.hasNextLine()){
	        text.append(scanner.nextLine() + NL);
	      }
	    }
	    finally{
	      scanner.close();
	    }
		return text.toString();
	}
}
