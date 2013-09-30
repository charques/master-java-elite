package edu.masterjava.javainiciacion.tarea05;

/**
 * Clase para el calculo de espacio recorrido.
 * 
 * @author carloshernandezarques
 *
 */
public class CalculaET {

	/**
	 * Espacio inicial
	 */
	final static float EI = 12.3f;
	/**
	 * Velocidad
	 */
	final static float V = 3.5f;
	
	/**
	 * Calcula el espacio recorrido en el tiempo t
	 * @param t tiempo
	 * @return
	 */
	public static float calcularEspacioRecorrido(float t) {
		if(t > 0) {
			return V * t + EI;
		}
		return 0;
	}
}
