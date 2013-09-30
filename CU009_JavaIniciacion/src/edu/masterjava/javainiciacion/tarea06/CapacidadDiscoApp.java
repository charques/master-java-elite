/**
 * 
 */
package edu.masterjava.javainiciacion.tarea06;

import java.text.DecimalFormat;

/**
 * 
 * Escriba un programa que calcule la capacidad de un disco duro de un ordenador que tiene
 * 12020 cilindros, 16 pistas, 8 sectores por pista y sectores de 512 bytes. Exprese su tama–o
 * en bytes, kilobytes, megabytes y gigabytes. El tama–o del disco se calcula de acuerdo con
 * la siguiente f—rmula:
 * 	
 * 		capacidad = cilindros * pistas * sectores * bytes
 * 
 * Un kilobyte son 1024 byts. Un megabyte son (kilobyte * 1024) bytes. Un gigabyte es
 * (megabyte * 1024) bytes.
 * 
 * @author carloshernandezarques
 *
 */
public class CapacidadDiscoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DiscoDuro discoDuro = new DiscoDuro(12020, 16, 8, 512);
		
		System.out.println("La capacidad del disco es:");
		
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println(" - " + df.format(discoDuro.capacidadB()) + " Bytes");
		System.out.println(" - " + df.format(discoDuro.capacidadKB()) + " KB");
		System.out.println(" - " + df.format(discoDuro.capacidadMB()) + " MB");
		System.out.println(" - " + df.format(discoDuro.capacidadGB()) + " GB");
	}

}
