/**
 * 
 */
package edu.masterjava.javainiciacion.tarea17;

/**
 * 
 * Ficha de tres en raya.
 * 
 * @author carloshernandezarques
 *
 */
public class Ficha {

	/**
	 * Id de jugador.
	 */
	private int jugador;
	
	/**
	 * Constructor
	 */
	public Ficha(int pJugador) {
		this.jugador = pJugador;
	}

	/**
	 * @return the jugador
	 */
	public int getJugador() {
		return jugador;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

}
