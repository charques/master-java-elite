package edu.masterjava.javainiciacion.tarea20;

/**
 * Movimiento/jugada de ajedrez.
 *  
 * @author carloshernandezarques
 */
public class Movimiento {

	/**
	 * Posici—n origen
	 */
	private Posicion origen;
	/**
	 * Posici—n destino
	 */
	private Posicion destino;
	
	/**
	 * Constructor de movimiento a partir de una posici—n
	 * y el incremento de X e Y.
	 */
	public Movimiento(Posicion p, int incCol, int incFil) {
        origen = new Posicion(p.getCol(), p.getFil());
        destino = new Posicion(p.getCol() + incCol, p.getFil() + incFil);
    }
	
	/**
	 * Constructor de movimiento a partir de una cadena con
	 * formato AB-AB
	 * @param cadena
	 */
	public Movimiento(String cadena) {
        origen = new Posicion(cadena.substring(0, 2));
        destino = new Posicion(cadena.substring(3, 5));
    }
	
	/**
	 * Comprueba si 2 movimientos son iguales.
	 */
	public boolean equals(Object obj) {
		if ( this == obj ) 
			return true;
		if ( !(obj instanceof Movimiento) ) 
			return false;
		Movimiento mov = (Movimiento) obj;
		return (origen.equals(mov.origen) && destino.equals(mov.destino));
	}

	/**
	 * @return the origen
	 */
	public Posicion getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(Posicion origen) {
		this.origen = origen;
	}

	/**
	 * @return the destino
	 */
	public Posicion getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Posicion destino) {
		this.destino = destino;
	}

	
}
