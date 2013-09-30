/**
 * 
 */
package edu.masterjava.javaintermedio.tarea06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


/**
 * 
 * Tarea 6. Crear un servidor de chat, su misión es retransmitir 
 * lo que reciba desde cualquier cliente a todos los clientes 
 * conectados. Para ello el servidor debe de mantener un Vector 
 * que contenga a todos los Sockets de los clientes que estén 
 * conectados. El servidor debe de ser multihilo, para permitir 
 * atender a cualquier cliente.
 * 
 * @author carloshernandezarques
 * 
 */
public class ChatServer {

	private static final int PORT = 4444;
	static protected Vector clientesConectados=new Vector(20, 5);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try 
		{
			ServerSocket listener = new ServerSocket(PORT);
			Socket server;

			System.out.println("ChatServer v0.1 iniciado...");
			
			int i = 1;
			while(true)
			{
				// Acepta conexiones de clientes e inicia el hilo de gestión de
				// cliente.
				server = listener.accept();
				ChatClientHandler clientHandler = new ChatClientHandler(server, i);
				clientesConectados.add(clientHandler);				
				clientHandler.start();
				i++;
			}
			 
		}
		catch(IOException e)
		{
			System.out.println("ChatServer Error: " + e.getMessage());
		}
	}
}