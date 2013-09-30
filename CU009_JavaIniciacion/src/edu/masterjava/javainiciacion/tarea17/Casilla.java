/**
 * 
 */
package edu.masterjava.javainiciacion.tarea17;

/**
 * 
 * Clase que representa una casilla del tablero.
 * 
 * @author carloshernandezarques
 *
 */
public class Casilla {

	/**
	 * Posicion de casilla.
	 */
	private int posicion;
	
	private Ficha ficha;
	
	
	/**
	 * Constructor
	 */
	public Casilla(int pPosicion) {
		this.posicion = pPosicion;
	}

	/**
	 * Coloca una ficha en la casilla.
	 * @param pFicha
	 * @return
	 */
	public boolean colocarFicha(Ficha pFicha) {
		if(estaLibre()) {
			this.ficha = pFicha;
			return true;
		}
		return false;
	}
	
	/**
	 * Indica si la casilla esta libre.
	 * @return
	 */
	public boolean estaLibre() {
		if(this.ficha == null) {
			return true;
		}
		return false;
	}

	/**
	 * @return la posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @return the ficha
	 */
	public Ficha getFicha() {
		return ficha;
	}
	
	
}
