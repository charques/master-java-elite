/**
 * 
 */
package edu.masterjava.javainiciacion.tarea09;

/**
 * 
 * Definan dos variables booleanas. Con ayuda de estas variables, imprima la tabla de verdad
 * de los operadores l—gicos AND, OR .
 * 
 * @author carloshernandezarques
 *
 */
public class TablaVerdadApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean var1 = true;
		boolean var2 = false;
		
		boolean and1 = var1 && var1;
		boolean and2 = var1 && var2;
		boolean and3 = var2 && var1;
		boolean and4 = var2 && var2;
		System.out.println("Tabla de verdad de AND");
		System.out.println("----------------------");
		System.out.println( var1 + " AND " + var1 + " = " + and1 );
        System.out.println( var1 + " AND " + var2 + " = " + and2 );
        System.out.println( var2 + " AND " + var1 + " = " + and3 );
        System.out.println( var2 + " AND " + var2 + " = " + and4 );
		
        System.out.println("");
        
		boolean or1 = var1 || var1;
		boolean or2 = var1 || var2;
		boolean or3 = var2 || var1;
		boolean or4 = var2 || var2;
		
		System.out.println("Tabla de verdad de OR");
		System.out.println("----------------------");
		System.out.println( var1 + " OR " + var1 + " = " + or1 );
        System.out.println( var1 + " OR " + var2 + " = " + or2 );
        System.out.println( var2 + " OR " + var1 + " = " + or3 );
        System.out.println( var2 + " OR " + var2 + " = " + or4 );

	}

}
