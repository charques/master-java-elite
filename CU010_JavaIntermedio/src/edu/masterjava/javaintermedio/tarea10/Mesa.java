package edu.masterjava.javaintermedio.tarea10;
/**
 * 
 * Implementa una mesa
 * 
 * @author carloshernandezarques
 *
 */
public class Mesa {

	private boolean disponible;
	
	private int objeto;

	/**
	 * @return the objeto
	 */
	public synchronized int getObjeto() {
		while (disponible == false) {
	        try {
	            // Espera a que el productor ponga un valor
	            wait();
	        } catch (InterruptedException e) {
	        }
	    }
		disponible = false;
	    // Notifica al productor que se recogido el objeto
	    notifyAll();
	    return objeto;
	}

	/**
	 * @param objeto the objeto to set
	 */
	public synchronized void setObjeto(int value) {
		while (disponible == true) {
	        try {
	            // Espera a que el consumidor recoja el valor
	            wait();
	        } catch (InterruptedException e) {
	        }
	    }
	    this.objeto = value;
	    disponible = true;
	    // Notifica al consumidor que se ha dejado un objeto
	    notifyAll();
	}
	
}
