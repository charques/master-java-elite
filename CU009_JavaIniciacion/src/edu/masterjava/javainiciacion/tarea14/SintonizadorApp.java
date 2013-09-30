/**
 * 
 */
package edu.masterjava.javainiciacion.tarea14;

/**
 * 
 * Se quiere definir una clase que permita controlar un sintonizador digital de emisoras FM;
 * concretamente, lo que se desea es dotar al controlador de una interfaz que permita subir o
 * bajar la frecuencia (en saltos de 0.5 MHz) y mostrar la frecuencia sintonizada en un
 * momento dado (getFrecuencia). Supondremos que el rango de frecuencias a manejar oscila
 * entre los 80 Mhz y los 108 MHz y que al inicio, el controlador sintoniza a 80 MHz. Si durante
 * una operaci—n de subida o bajada se sobrepasa uno de los dos l’mites, la frecuencia
 * sintonizada debe pasar a ser la del extremo contrario.
 * 
 * @author carloshernandezarques
 *
 */
public class SintonizadorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SintronizadorFM sintonizador = new SintronizadorFM();
		System.out.println("Frecuencia : " + sintonizador.getFrecuencia() + " Mhz");
		sintonizador.bajar();
		System.out.println("Frecuencia : " + sintonizador.getFrecuencia() + " Mhz");
		sintonizador.bajar();
		sintonizador.bajar();
		sintonizador.bajar();
		System.out.println("Frecuencia : " + sintonizador.getFrecuencia() + " Mhz");
		sintonizador.subir();
		sintonizador.subir();
		sintonizador.subir();
		System.out.println("Frecuencia : " + sintonizador.getFrecuencia() + " Mhz");
		sintonizador.subir();
		sintonizador.subir();
		sintonizador.subir();
		System.out.println("Frecuencia : " + sintonizador.getFrecuencia() + " Mhz");
	}

}
