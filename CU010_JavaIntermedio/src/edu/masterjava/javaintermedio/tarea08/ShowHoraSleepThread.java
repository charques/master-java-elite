/**
 * 
 */
package edu.masterjava.javaintermedio.tarea08;

import java.util.Date;

/**
 * 
 * Thread que muestra la hora cada segundo de manera indefinida.
 * 
 * @author carloshernandezarques
 * 
 */
class ShowHoraSleepThread extends Thread {

	public ShowHoraSleepThread() {
		super();
	}

	public void run() {
		do {
			try {
				sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("sleep: " + (new Date()).toString());
		} while(true);
	}
}
