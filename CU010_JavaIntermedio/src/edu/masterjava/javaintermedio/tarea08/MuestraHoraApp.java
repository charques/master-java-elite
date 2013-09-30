/**
 * 
 */
package edu.masterjava.javaintermedio.tarea08;

/**
 * 
 * Tarea 8. Crear un programa que muestre la hora cada segundo, para 
 * ello emplearemos un hilo encargado de realizar dicha tarea.
 * 
 * @author carloshernandezarques
 *
 */
public class MuestraHoraApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ShowHoraSleepThread().start();
		new ShowHoraTimerThread().start();
	}

}
