/**
 * 
 */
package edu.masterjava.javaintermedio.tarea09;

/**
 * 
 * Tarea 9. Realizar un programa en el que existan 3 hilos 
 * que muestren en pantalla cada 15 segundos un mensaje.
 * 
 * @author carloshernandezarques
 *
 */
public class MuestraMensajeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ShowMensajeThread("Madrid").start();
		new ShowMensajeThread("Barcelona").start();
		new ShowMensajeThread("Murcia").start();
	}

}
