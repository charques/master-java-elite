package edu.masterjava.javaintermedio.tarea06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;

/**
 * Implementa un hilo de gesti—n de cliente.
 * @author carloshernandezarques
 *
 */
public class ChatClientHandler extends Thread
{
	Socket socket;
	int id;
	
	PrintWriter salida;
	BufferedReader entrada;

	/**
	 * Constructor.
	 * @param socket
	 * @param id
	 */
	ChatClientHandler(Socket socket, int id)
	{
		this.socket = socket;
		this.id = id;

		try{
			//Inicia la entrada/salida
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new PrintWriter(socket.getOutputStream());
			
			enviarMensajeTodos("Usuario " + id + " conectado.");
		}
		catch(IOException e)
		{
			System.out.println("ChatClientHandler Error: " + e.getMessage());
		}
	}

	/**
	 * MŽtodo run del hilo. Contiene el bucle de gesti—n del hilo.
	 */
	public void run()
	{
		try{
			while(true)
			{
					String mensaje = entrada.readLine();
					if(mensaje == "q")
						break;
					enviarMensajeTodos("Usuario " + id + ": " + mensaje);
			}
			socket.close();
			ChatServer.clientesConectados.remove(this);
		}
		catch(IOException e)
		{
			System.out.println("ChatClientHandler Run Error: " + e.getMessage());
		}
	}
	
	/**
	 * Env’a el mensaje a todos los clientes.
	 * @param mensaje
	 */
	public void enviarMensajeTodos(String mensaje)
	{
		Iterator itr = ChatServer.clientesConectados.iterator();
		while(itr.hasNext())
		{
			ChatClientHandler clientHandler = (ChatClientHandler) itr.next();
			clientHandler.escribeMensaje(mensaje);
		}
	}
	
	/**
	 * Escribe un mensaje en la salida del cliente.
	 * @param mensaje
	 */
	public void escribeMensaje(String mensaje)
	{
		if(salida != null){
			salida.println(mensaje);
			salida.flush();
		}
	}
	
	
}