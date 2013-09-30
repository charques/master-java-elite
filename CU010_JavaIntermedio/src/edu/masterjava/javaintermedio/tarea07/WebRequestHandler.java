package edu.masterjava.javaintermedio.tarea07;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Clase que implementa el hilo de gestion de peticiones
 * 
 * @author carloshernandezarques
 * 
 */
public class WebRequestHandler implements Runnable {

	private static final String GET = "GET";

	private Socket socket;

	WebRequestHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {

			// Construye los flujos de entrada/salida
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			BufferedOutputStream salida = new BufferedOutputStream(
					socket.getOutputStream());

			// Obtiene la solicitud y la procesa
			byte[] cabecera;
			byte[] pagina;
			try {
				// obtiene el path del fichero
				String path = obtenerPath(entrada);
				System.out.println("GET " + path);

				// construye la pagina solicitada
				cabecera = buildHttpHeader(200);
				pagina = leeFicheroCompleto(path);

			} catch (WebRequestException e) {
				// construye la pagina de error
				cabecera = buildHttpHeader(e.getCode());
				pagina = e.getMessage().getBytes();
			}

			// escribe en la salida
			salida.write(cabecera);
			salida.write(pagina);
			salida.flush();

			// cierra los flujos y el socket
			entrada.close();
			salida.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Procesa la cadena de petici—n y devuelve el path del ichero a devolver
	 * 
	 * @param peticion
	 * @return
	 * @throws WebRequestException
	 */
	private String obtenerPath(BufferedReader entrada)
			throws WebRequestException {
		String peticion = "";
		try {
			peticion = entrada.readLine();
		} catch (IOException e) {
			throw new WebRequestException(
					WebRequestException.CODE_ERROR_INTERNAL_SERVER_ERROR,
					WebRequestException.MESSAGE_ERROR_INTERNAL_SERVER_ERROR);
		}

		StringTokenizer st = new StringTokenizer(peticion);
		int conta = 0;
		while (st.hasMoreTokens()) {
			if ((conta == 0) && !GET.equals(st.nextToken())) {
				throw new WebRequestException(
						WebRequestException.CODE_ERROR_BAD_REQUEST,
						WebRequestException.MESSAGE_ERROR_BAD_REQUEST);
			} else if (conta == 1) {
				// devuelve el path del fichero
				return st.nextToken();
			}
			conta++;
		}
		throw new WebRequestException(
				WebRequestException.CODE_ERROR_BAD_REQUEST,
				WebRequestException.MESSAGE_ERROR_BAD_REQUEST);
	}

	/**
	 * Lee el fichero completo
	 * 
	 * @param path
	 * @return
	 * @throws WebRequestException
	 */
	private byte[] leeFicheroCompleto(String path) throws WebRequestException {
		FileInputStream file;
		byte[] b;
		try {
			file = new FileInputStream("htdocs" + path);

			DataInputStream in = new DataInputStream(file);

			b = new byte[in.available()];
			in.readFully(b);
			in.close();
		} catch (FileNotFoundException e) {
			throw new WebRequestException(
					WebRequestException.CODE_ERROR_NOT_FOUND,
					WebRequestException.MESSAGE_ERROR_NOT_FOUND);
		} catch (IOException e) {
			throw new WebRequestException(
					WebRequestException.CODE_ERROR_INTERNAL_SERVER_ERROR,
					WebRequestException.MESSAGE_ERROR_INTERNAL_SERVER_ERROR);
		}

		return b;
	}

	/**
	 * Construye la cabecera
	 * 
	 * @param return_code
	 * @return
	 */
	private byte[] buildHttpHeader(int return_code) {
		String s = "HTTP/1.0 ";

		// gestiona codigos
		switch (return_code) {
		case 200:
			s = s + "200 OK";
			break;
		case 400:
			s = s + "400 Bad Request";
			break;
		case 404:
			s = s + "404 Not Found";
			break;
		case 500:
			s = s + "500 Internal Server Error";
			break;
		}

		// otros campos
		s = s + "\r\n";
		s = s + "Connection: close\r\n";
		s = s + "Server: WebServer v0.1\r\n";

		// tipo de fichero HTML
		s = s + "Content-Type: text/html\r\n";

		// fin de cabecera
		s = s + "\r\n";

		return s.getBytes();
	}

}
