/**
 * 
 */
package edu.masterjava.javainiciacion.tarea20;

import java.util.Scanner;

/**
 * 
 * Clase que representa una partida de ajedrez para 2 jugadores.
 * TODO: Enroques, comer al paso, transformaci—n de peones.
 * 
 * @author carloshernandezarques
 *
 */
public class Partida {
	
	private Tablero tablero;
	
	/**
	 * Constructor
	 */
	public Partida() {
		tablero = new Tablero();
	}
	
	public void iniciar() {
		Scanner kb = new Scanner(System.in);
		
		// Mensaje de bienvenida
		StringBuffer sb = new StringBuffer();
		sb.append("Ajedrez 1.0");
		sb.append("\n-------------------------------------------------------------------");
		sb.append("\nEmpiezan BLANCAS");
		sb.append("\nLa codificaci—n de movimientos sigue el siguiente formato ej. D2-D4");
		sb.append("\n-------------------------------------------------------------------");
		sb.append("\n");
		System.out.println(sb.toString());
		
		boolean fin = false;
		
		// Bucle principal
		do {
			// Pinta el tablero
			System.out.println(tablero.toString());
			
			// Captura movimiento analizando si es viable
			Movimiento movimiento = this.capturarMovimiento(kb, tablero);
			// Ejecuta el movimiento y cambia de turno
			int status = tablero.mover(movimiento);
			
			// Detecta jaque mate
			if(status == 2) {
				fin = true;
			}
			
		} while (! fin);
		
		StringBuffer bf = new StringBuffer();
		bf.append("Ganan ");
		String colorTurnoOpuesto = (tablero.getTurno()==Constantes.BLANCAS) ? "NEGRAS" : "BLANCAS";
		bf.append(colorTurnoOpuesto);
		bf.append("!!");
		System.out.println(bf.toString());
		
		System.exit(0);
	}
	
	/**
	 * Captura un movimiento analizando si es posible en funci—n del turno actual.
	 * @return
	 */
	private Movimiento capturarMovimiento(Scanner kb, Tablero tablero) {
		String pos;
		Movimiento mov;
		do {
			StringBuffer bf = new StringBuffer();
			bf.append("Movimiento ");
			String colorTurno = (tablero.getTurno()==Constantes.BLANCAS) ? "BLANCAS" : "NEGRAS";
			bf.append(colorTurno + " : ");
			System.out.print(bf.toString());
			
			pos = kb.nextLine();
			mov = new Movimiento(pos);
			
		} while (!tablero.esMovimientoPosible(mov));
		
		return mov;
	}
	
}
