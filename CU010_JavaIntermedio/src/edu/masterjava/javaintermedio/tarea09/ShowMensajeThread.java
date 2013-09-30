/**
 * 
 */
package edu.masterjava.javaintermedio.tarea09;


/**
 * 
 * Thread que muestra el mensaje cada 15 segundos.
 * 
 * @author carloshernandezarques
 * 
 */
class ShowMensajeThread extends Thread {

	public ShowMensajeThread(String mensaje) {
		super(mensaje);
	}

	public void run() {
		do {
			try {
				sleep(15000);
			} catch (InterruptedException e) {}
			System.out.println(getName());
		} while(true);
	}
}
