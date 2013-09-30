/**
 * 
 */
package edu.masterjava.javainiciacion.tarea14;

/**
 * 
 * Clase que implementa un sintonizador FM
 * 
 * @author carloshernandezarques
 *
 */
public class SintronizadorFM {

	// Constantes
	private final float PASO_FREC = 0.5f;
	private final int FREC_MIN = 80;
	private final int FREC_MAX = 108;
	
	/**
	 * Frecuencia
	 */
	private float frecuencia;
	
	
	/**
	 * Constructor
	 */
	public SintronizadorFM() {
		this.frecuencia = FREC_MIN;
	}
	
	/**
	 * Sube la frecuencia 0.5 MHz
	 */
	public void subir() {
		this.frecuencia += PASO_FREC;
		
		// Si la frecuencia supera la frecuencia m‡xima
		// pasa autom‡ticamente al extremo contrario
		if(this.frecuencia > FREC_MAX) {
			this.frecuencia = FREC_MIN;
		}
	}
	
	/**
	 * Baja la frecuencia 0.5 MHz
	 */
	public void bajar() {
		this.frecuencia -= PASO_FREC;
		
		// Si la frecuencia baja de la frecuencia m’nima
		// pasa autom‡ticamente al extremo contrario
		if(this.frecuencia < FREC_MIN) {
			this.frecuencia = FREC_MAX;
		}
	}

	/**
	 * @return the frecuencia
	 */
	public float getFrecuencia() {
		return frecuencia;
	}
	
	

}
