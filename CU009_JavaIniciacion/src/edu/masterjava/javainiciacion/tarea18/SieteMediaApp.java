/**
 * 
 */
package edu.masterjava.javainiciacion.tarea18;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Construir el juego de cartas de las siete y media, similar al blackJack.
 * 
 * @author carloshernandezarques
 * 
 */
public class SieteMediaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		float carta = 0;
		float jugador1Total = 0;
		float jugador2Total = 0;
		String kbString = "";
		char kbChar = 's';

		Random random = new Random();
		Scanner kb = new Scanner(System.in);

		// Mensaje de bienvenida
		System.out.println("Bienvenido a las Siete y media!!!");
		System.out.println("Repartiendo cartas...");

		// Obtiene la primera carta del jugador 1
		carta = cogerCarta(random);
		jugador1Total += carta;

		// Obtiene la puntuaci—n del jugador 2
		jugador2Total = player2IA(random);

		// Bucle de petici—n de cartas
		do {
			System.out.println("\nHas cogido un " + carta + ", tienes "
					+ jugador1Total + " puntos");
			System.out.print("ÀQuieres otra carta? (s,n): ");
			kbString = kb.next();
			kbChar = kbString.charAt(0);
			if (kbChar == 's') {
				carta = cogerCarta(random);
				jugador1Total += carta;
			}
		} while ((kbChar == 's') && (jugador1Total <= 7.5));

		// Comprueba resultado
		System.out.print("\n");
		if (jugador1Total > 7.5) {
			System.out.println("Te has pasado!!! Tienes " + jugador1Total);
		} 
		else {
			System.out
					.println("Tienes " + jugador1Total
							+ " puntos, el Jugador2 tiene " + jugador2Total
							+ " puntos");

			if ((jugador1Total > jugador2Total) && (jugador1Total <= 7.5)) {
				System.out.println("Has ganado!!");
			} 
			else if (jugador1Total < jugador2Total) {
				System.out.println("Has perdido!!");
			} 
			else if (jugador1Total == jugador2Total) {
				System.out.println("Habe’s empatado!!");
			}
		}
		System.exit(0);
	}

	/**
	 * Simula la acci—n de coger una carta del 1 al 7, o una figura con valor
	 * 1/2.
	 * 
	 * @param random
	 * @return
	 */
	private static float cogerCarta(Random random) {
		int carta = random.nextInt(9) + 1;
		if ((carta == 8) || (carta == 9) || (carta == 10)) {
			return 0.5f;
		}
		return carta;
	}

	/**
	 * Obtiene una jugada de Siete y media.
	 * 
	 * @param random
	 * @return
	 */
	private static float player2IA(Random random) {
		float total = 2;
		// Obtiene un valor entre 2 y 7.
		total = total + (random.nextInt(4) + 1);
		// Da la posibilidad de obtener la media.
		if (cogerCarta(random) == 0.5) {
			total += 0.5;
		}
		return total;
	}

}
