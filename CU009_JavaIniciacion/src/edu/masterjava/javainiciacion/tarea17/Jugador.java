/**
 * 
 */
package edu.masterjava.javainiciacion.tarea17;

/**
 * 
 * Clase que representa a un juegador.
 * 
 * @author carloshernandezarques
 *
 */
public class Jugador {

	private int idJugador;
	
	/**
	 * Constructor
	 */
	public Jugador(int pIdJugador) {
		this.idJugador = pIdJugador;
	}

	/**
	 * @return the idJugador
	 */
	public int getIdJugador() {
		return idJugador;
	}
	
	/**
	 * Obtiene una ficha del jugador
	 * @return
	 */
	public Ficha obtenerFicha() {
		Ficha ficha = new Ficha(idJugador);
		
		return ficha;
	}
	
}
