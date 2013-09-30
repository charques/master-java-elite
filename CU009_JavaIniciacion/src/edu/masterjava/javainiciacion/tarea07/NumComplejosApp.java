/**
 * 
 */
package edu.masterjava.javainiciacion.tarea07;

/**
 * 
 * Escriba una clase que permita manejar números complejos, construya métodos para las
 * cuatro operaciones fundamentales.
 * 
 * @author carloshernandezarques
 *
 */
public class NumComplejosApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// suma
		Complejo c1 = new Complejo(1.0, 3.0);
        Complejo c2 = new Complejo(-2.0, 2.0);
        Complejo resultado=Complejo.suma(c1, c2);
        System.out.println("Suma "+resultado);
        
        // resta
      	resultado=Complejo.resta(c1, c2);
        System.out.println("Resta "+resultado);
        
        //producto
        resultado=Complejo.producto(c1, c2);
        System.out.println("Producto "+resultado);
        
        //cociente
        try{
            resultado=Complejo.cociente(c1, c2);
        }
        catch(ExcepcionDivisionCero e){
            System.out.println("Excepción: " + e.getClass() + " - " + e.getMessage());
        }
        System.out.println("Cociente "+resultado);
	}

}
