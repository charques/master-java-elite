/**
 * 
 */
package edu.masterjava.javaintermedio.tarea07;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * Tarea 7. Crear un servidor WEB, teniendo en cuenta que cuando se pide una
 * p‡gina web el navegador env’a una cadena con el siguiente formato:
 * 
 * GET /carpeta/fichero.html HTTP/1.0\r\n\r\n
 * 
 * El servidor debe de leer una l’nea de texto del cliente con el formato
 * anterior, debe de obtener el nombre del fichero de dicha l’nea
 * (/carpeta/fichero.html) y debe de buscarlo en una carpeta que denominaremos
 * ra’z. Si no existe el fichero en la carpeta ra’z, hay que enviar una cadena
 * de texto, con salto de l’nea al final, al cliente para informarle del error.
 * Si existe el fichero en la carpeta ra’z, hay que leer el fichero y enviarlo
 * al cliente. En ambos casos es necesario realizar un flush de lo enviado, y
 * asegurarnos que se cierra el socket.
 * 
 * (Puede ser interesante emplear la clase java.util.StringTokenizer para
 * descomponer la cadena le’da del cliente en trozos a partir de los espacios en
 * blanco).
 * 
 * Para emplear un navegador para pedir un fichero a nuestro servidor WEB
 * podemos utilizar la siguiente ruta:
 * 
 * http://servidor:puerto/carpeta/fichero.html
 * 
 * sustituyendo servidor por la direcci—n ip de nuestra m‡quina, puerto es el
 * nœmero de puerto en el que escucha el ServerSocket y /carpeta/fichero.html es
 * el fichero que queremos acceder desde nuestro servidor web.
 * 
 * ------------------------------------------------------------------------------
 * 
 * El directorio base del servidor es HTDOCS
 * 
 * http://localhost:8080/test/hello.html
 *
 * ------------------------------------------------------------------------------
 * 
 * @author carloshernandezarques
 * 
 */
public class WebServer {

	private static final int PORT = 8080;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ServerSocket listener = new ServerSocket(PORT);
			Socket server;
			
			System.out.println("WebServer v0.1 iniciado...");

			// Acepta las peticiones y crea hilos
			while (true) {
				server = listener.accept();
				WebRequestHandler wrh = new WebRequestHandler(server);
				Thread t = new Thread(wrh);
				t.start();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}


