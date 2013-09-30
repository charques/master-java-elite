package edu.masterjava.javaintermedio.tarea03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Implementa un copiador de ficheros.
 * El fichero origen y destino deben existir.
 * 
 * @author carloshernandezarques
 */
public class FileCopier {

	private final String fileName1;
	private final String fileName2;

	/**
	 * Constructor
	 * 
	 * @param aFileName
	 * @param bFileName
	 */
	public FileCopier(String aFileName, String bFileName) {
		fileName1 = aFileName;
		fileName2 = bFileName;
	}
	
	/**
	 * Copia los ficheros
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void copy(boolean toUpperCase) throws FileNotFoundException, IOException {
		try{
			// Crea los stream de entrada y salida
			InputStream in = new FileInputStream(fileName1);
			OutputStream out = new FileOutputStream(fileName2);

			// Procesa el contenido del fichero
			byte[] buf = new byte[1024];
			
			int len;
			while ((len = in.read(buf)) > 0){
				
				//TODO upercase
				
				out.write(buf, 0, len);
			}
			
			// Cierra los ficheros
			in.close();
			out.close();
			
			System.out.println("Copia finalizada. Mayus: " + toUpperCase);
		}
		catch(FileNotFoundException ex){
			throw ex;
		}
		catch(IOException e){
			throw e;
		}
	}
}
