/**
 * 
 */
package edu.masterjava.javaintermedio.tarea04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * Tarea 4. Realizar un servidor que se quede a la escucha en el puerto 3000,
 * cuando se conecte un cliente debe de enviarle una cadena de texto,
 * peri—dicamente, con la fecha y hora actuales del sistema.
 * 
 * @author carloshernandezarques
 * 
 */
public class DateTimeServer {

	private static final String Q = "q";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int PUERTO = 3000;
		ServerSocket srvSocket;
		Socket socket;
		DataOutputStream salida;
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

			// Crea canales de entrada/salida de datos
			entrada = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Conexi—n realizada con Žxito...\n");

			// Inicia el timer que "salta" cada 2 segundos
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new EnviaMensaje(salida), 0, 2000);

			// Loop que mantiene el servidor activo hasta que el usuario manda 
			// una "q"
			String mensajeRecibido = null;
			do {
				mensajeRecibido = entrada.readLine();
				//System.out.println(mensajeRecibido);
			} while ((mensajeRecibido != null) && !Q.equals(mensajeRecibido));

			// Cancela el timer y cierra la conexi—n con el cliente
			timer.cancel();
			System.out.println("Cerrando conexi—n...");
			srvSocket.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

/**
 * Clase que implementa la tarea asociada al Timer.
 * 
 * @author carloshernandezarques
 */
class EnviaMensaje extends TimerTask {
	private DataOutputStream salida;

	public EnviaMensaje(DataOutputStream pSalida) {
		salida = pSalida;
	}

	public void run() {
		try {
			salida.writeUTF((new Date()).toString() + "\n");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}