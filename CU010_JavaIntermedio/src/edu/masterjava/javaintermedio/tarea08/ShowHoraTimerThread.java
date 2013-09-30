/**
 * 
 */
package edu.masterjava.javaintermedio.tarea08;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * Thread que muestra la hora cada segundo de manera indefinida.
 * Utiliza un timer.
 * 
 * @author carloshernandezarques
 * 
 */
class ShowHoraTimerThread extends Thread {

	public ShowHoraTimerThread() {
		super();
	}

	public void run() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MuestraHora(), 0, 1000);
	}
}

/**
 * Clase que implementa la tarea asociada al Timer.
 * 
 * @author carloshernandezarques
 */
class MuestraHora extends TimerTask {
	
	public MuestraHora() {
	}

	public void run() {
		System.out.println("timer: " + (new Date()).toString());
	}
}
