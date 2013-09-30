/**
 * 
 */
package edu.masterjava.javaintermedio.tarea10;

/**
 * 
 * Thread que implementa el productor.
 * 
 * @author carloshernandezarques
 * 
 */
class Productor extends Thread {
	private Mesa mesa;
	private int id;
	private int numObjetosProducir;
	
	public Productor(int id, Mesa m, int numObjetos) {
		this.id = id;
		this.mesa = m;
		this.numObjetosProducir = numObjetos;
	}

	public void run() {
		for (int i = 0; i < numObjetosProducir; i++) {
			mesa.setObjeto(i);
			System.out.println("P: " + this.id + " obj: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
