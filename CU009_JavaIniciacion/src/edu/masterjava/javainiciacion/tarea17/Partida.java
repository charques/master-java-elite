/**
 * 
 */
package edu.masterjava.javainiciacion.tarea17;

import java.util.Scanner;

/**
 * 
 * Clase que representa una partida de tres en raya.
 * 
 * @author carloshernandezarques
 *
 */
public class Partida {

	final static private int ID_JUGADOR_1 = 1;
	final static private int ID_JUGADOR_2 = 2;
	
	private int turno;
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	private Tablero tablero;
	
	/**
	 * Constructor
	 */
	public Partida() {
		jugador1 = new Jugador(ID_JUGADOR_1);
		jugador2 = new Jugador(ID_JUGADOR_2);
		
		tablero = new Tablero();
	}
	
	public void jugar() {
		Scanner kb = new Scanner(System.in);
		Ficha ficha;
		int posX;
		int posY;
		boolean colocada;
		int resultado;
		
		
		// Mensaje de bienvenida
		System.out.println("Bienvenido a las Tres en Raya!!!");
		System.out.println("Sorteando que jugador empieza...");
		
		turno = ID_JUGADOR_1;
		
		do {
			do {
				StringBuffer buffer = new StringBuffer();
				buffer.append("\nTurno del jugador ");
				buffer.append(turno);
				if(turno == ID_JUGADOR_1) {
					ficha = jugador1.obtenerFicha();
				}
				else {
					ficha = jugador2.obtenerFicha();
				}
				buffer.append(". Seleccione la posici—n de la ficha.");
				System.out.println(buffer.toString());
				
				posX = obtenerCoordenada(kb, "x");
				posY = obtenerCoordenada(kb, "y");
				colocada = tablero.colocarFicha(ficha, posX, posY);
				
				// Si la posicion esta ocupada.
				if(!colocada) {
					System.out.print("La posici—n (" + posX + ", " + posY + ") est‡ ocupada.");
				}
				
				// Sale del bucle cuando el usuario que tiene el turno coloque una ficha.
			} while(!colocada);
			
			cambiarTurno();
			System.out.println("");
			tablero.dibujar();
			
			resultado = tablero.checkTresEnRaya();

			// La partida acaba cuando hay un ganador o se completa el tablero en tablas.
		} while ((resultado < 0)  &&  (! tablero.estaCompleto()));
		
		// Trata el resultados
		switch (resultado) {
			case 1:
				System.out.println("\nEl jugador 1 ha ganado!!");
				break;
			case 2:
				System.out.println("\nEl jugador 2 ha ganado!!");
				break;
			case 99:
				System.out.println("\nTablas!!");
				break;
		}
		
		System.exit(0);
	}

	/**
	 * Cambia el turno de juego.
	 */
	private void cambiarTurno() {
		if (turno == ID_JUGADOR_1) {
			turno = ID_JUGADOR_2;
		}
		else {
			turno = ID_JUGADOR_1;
		}
	}
	
	/**
	 * Obtiene un valor de coordenada entre 1 y 3.
	 * @param kb
	 * @param tipo
	 * @return
	 */
	private int obtenerCoordenada(Scanner kb, String tipo) {
		int pos;
		do {
			System.out.print("Coordenada "+ tipo + " (1-3): ");
			pos = kb.nextInt();
		} while ((pos < 1) && (pos > 3));
		
		return pos;
	}
	
	
	
}
