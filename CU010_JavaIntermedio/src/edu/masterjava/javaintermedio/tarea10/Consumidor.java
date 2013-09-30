/**
 * 
 */
package edu.masterjava.javaintermedio.tarea10;

/**
 * 
 * Thread que implementa el consumidor.
 * 
 * @author carloshernandezarques
 * 
 */
class Consumidor extends Thread {
	private Mesa mesa;
	private int id;
	private int numObjetosConsumir;

	public Consumidor(int id, Mesa m, int numObjetos) {
		this.id = id;
		this.mesa = m;
		this.numObjetosConsumir = numObjetos;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < numObjetosConsumir; i++) {
			value = mesa.getObjeto();
			System.out.println("C: " + this.id + " obj: " + value);
		}
	}
}
