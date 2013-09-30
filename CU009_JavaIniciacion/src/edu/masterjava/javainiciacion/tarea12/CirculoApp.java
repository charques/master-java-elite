/**
 * 
 */
package edu.masterjava.javainiciacion.tarea12;

import java.text.DecimalFormat;

/**
 * 
 * Escriba una clase Java que represente un círculo; el círculo queda perfectamente definido si
 * se conoce su radio y las coordenadas x e y del centro. Defina además, para esta clase, dos
 * métodos (públicos) que permitan calcular el área del círculo y el perímetro de la
 * circunferencia que delimita el círculo.
 * Para probar la funcionalidad antes definida, escriba un pequeño programa que cree un
 * círculo con un radio dado, y que calcule (y muestre por pantalla) el área y el perímetro de
 * su circunferencia.
 * 
 * @author carloshernandezarques
 *
 */
public class CirculoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Circulo circulo = new Circulo(2, 3, 10.5f);
		
		double area = circulo.area();
		double perimetro = circulo.perimetro();
		
		System.out.println(circulo.toString());
		
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println("Área : " + df.format(area));
		System.out.println("Perímetro : " + df.format(perimetro));
	}

}
