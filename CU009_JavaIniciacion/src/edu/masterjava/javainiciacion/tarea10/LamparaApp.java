/**
 * 
 */
package edu.masterjava.javainiciacion.tarea10;

/**
 * 
 * Defina una clase que represente el estado de una lampara (encendido o apagado). Defina
 * dos métodos que permitan encender y apagar la lampara.
 * Para probarlo, construya un método main que cree un objeto de la clase definida, que haga
 * uso de los métodos previamente definidos y vaya mostrando el estado de la lampara.
 * 
 * @author carloshernandezarques
 *
 */
public class LamparaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Lampara lampara = new Lampara();
		System.out.println(lampara.toString());

		lampara.encender();
		System.out.println(lampara.toString());
		
		lampara.apagar();
		System.out.println(lampara.toString());
	}

}
