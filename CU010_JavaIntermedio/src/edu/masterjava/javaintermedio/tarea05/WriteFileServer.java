/**
 * 
 */
package edu.masterjava.javaintermedio.tarea05;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * Tarea 5. Crear un servidor que guarde en un fichero de 
 * texto todo lo que reciba desde un cliente.
 * 
 * @author carloshernandezarques
 * 
 */
public class WriteFileServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int PUERTO = 3000;
		FileOutputStream fos;
		DataOutputStream dos;
		ServerSocket srvSocket;
		Socket socket;
		BufferedReader entrada;

		try {
			// Inicia el socket y se queda esperando una conexi—n por parte del
			// cliente
			srvSocket = new ServerSocket(PUERTO);
			socket = new Socket();
			System.out.println("Esperando una conexi—n en el puerto " + PUERTO);
			socket = srvSocket.accept();

			// Un cliente se ha conectado
			System.out.println("Un cliente se ha conectado.");
			
			// Crea el stream de escritura de fichero
            fos = new FileOutputStream("datos_server.dat");
            dos = new DataOutputStream(fos);

			// Crea canal de entrada de datos
			entrada = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// Loop que mantiene el servidor activo
			String mensajeRecibido = null;
			do {
				mensajeRecibido = entrada.readLine();
				// Escribe el mensaje recibido en el fichero
				if(mensajeRecibido != null) {
					System.out.print(mensajeRecibido);
					dos.writeUTF(mensajeRecibido);
				}
			} while ((mensajeRecibido != null));

			// Cancela el timer y cierra la conexi—n con el cliente
			System.out.println("Cerrando conexi—n...");
			srvSocket.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}