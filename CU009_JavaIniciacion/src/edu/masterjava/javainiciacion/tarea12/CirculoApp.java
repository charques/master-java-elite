/**
 * 
 */
package edu.masterjava.javainiciacion.tarea12;

import java.text.DecimalFormat;

/**
 * 
 * Escriba una clase Java que represente un c�rculo; el c�rculo queda perfectamente definido si
 * se conoce su radio y las coordenadas x e y del centro. Defina adem�s, para esta clase, dos
 * m�todos (p�blicos) que permitan calcular el �rea del c�rculo y el per�metro de la
 * circunferencia que delimita el c�rculo.
 * Para probar la funcionalidad antes definida, escriba un peque�o programa que cree un
 * c�rculo con un radio dado, y que calcule (y muestre por pantalla) el �rea y el per�metro de
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
		System.out.println("�rea : " + df.format(area));
		System.out.println("Per�metro : " + df.format(perimetro));
	}

}
