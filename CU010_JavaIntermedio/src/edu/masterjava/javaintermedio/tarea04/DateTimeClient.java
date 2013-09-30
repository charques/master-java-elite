/**
 * 
 */
package edu.masterjava.javaintermedio.tarea04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 * Tarea 4. Realizar un servidor que se quede a la escucha en el puerto 3000,
 * cuando se conecte un cliente debe de enviarle una cadena de texto,
 * peri—dicamente, con la fecha y hora actuales del sistema.
 * 
 * @author carloshernandezarques
 * 
 */
public class DateTimeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket clientSocket = null;
			BufferedReader in = null;

			clientSocket = new Socket("localhost", 3000);
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			// El cliente se desconecta al recibir 10 mensajes.
			int contador = 0;
			while (contador < 10) {
				System.out.println(in.readLine());
				contador++;
			}

			in.close();
			clientSocket.close();

		} catch (Exception e) {
			System.out.print("Error");
		}
	}
}
