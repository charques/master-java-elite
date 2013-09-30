/**
 * 
 */
package edu.masterjava.javaintermedio.tarea10;

/**
 * 
 * Tarea 10. Crear una aplicaci—n en la que exista un productor 
 * y un consumidor, ambos de tipo Thread, una Mesa. El productor 
 * debe de dejar encima de la mesa un producto, que ser‡ recogido 
 * por el consumidor. La restricci—n es que el productor debe de 
 * dormirse mientras que haya un producto en la mesa y el consumidor 
 * debe de dormirse mientras no haya un producto en la mesa. De esta 
 * manera el productor y el consumidor deben de alternarse: uno 
 * despierto y el otro dormido.
 * 
 * @author carloshernandezarques
 *
 */
public class ProductorConsumidorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		
        /* Prueba 1. 
		 	1 productor y 1 consumidor.
		 	Los limites de producci—n y consumici—n son iguales.
		 	El productor y el consumidor est‡n sincronizados. */
		Productor p1 = new Productor(1, mesa, 10);
        Consumidor c1 = new Consumidor(1, mesa, 10);
        p1.start();
        c1.start();
        
        
        
        /* Prueba 2. 
         	2 productores y 2 consumidor.
			Los limites de producci—n y consumici—n son iguales.
			Los productores y consumidores se sincronizan. */
        /*Productor p1 = new Productor(1, mesa, 10);
        Productor p2 = new Productor(2, mesa, 10);
        Consumidor c1 = new Consumidor(1, mesa, 10);
        Consumidor c2 = new Consumidor(2, mesa, 10);
        p1.start();
        p2.start();
        c1.start();
        c2.start();*/
		
        
        
		/* Prueba 3. 
		 	1 productor y 1 consumidor.
			Solo se producen 5 objetos. El consumidor
			queda esperando a que se a–ada un elemento. */
		/*Productor p1 = new Productor(1, mesa, 5);
		Consumidor c1 = new Consumidor(1, mesa, 10);
		p1.start();
		c1.start();*/
        
        
		
		/* Prueba 4. 
			1 productor y 1 consumidor.
		 	Solo se intentan producir 10 objetos, pero el consumidor
			est‡ limitado a 5 objetos. Queda un objeto encima de la mesa. */
		/*Productor p1 = new Productor(1, mesa, 10);
		Consumidor c1 = new Consumidor(1, mesa, 5);
		p1.start();
		c1.start();*/
	}

}
