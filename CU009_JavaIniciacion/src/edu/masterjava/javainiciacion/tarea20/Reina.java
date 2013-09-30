package edu.masterjava.javainiciacion.tarea20;

import java.util.ArrayList;

/**
 * Alfil de ajedrez
 * 
 * @author carloshernandezarques
 */
public class Reina extends Pieza {
	
	// Posibles direcciones. Codifica pares de incrementos en (columna, fila)
    private static int[][] posiblesMovimientos = 
        {{1,1}, {1,-1}, {-1,-1}, {-1,1}, {1,0}, {0,-1}, {-1,0}, {0,1}};

	/**
	 * Contructor
	 * @param posicion
	 * @param color
	 */
	public Reina(Posicion posicion, int color) {
		super(posicion, color);
	}

	@Override
	public ArrayList<Movimiento> posiblesMovimientos(Tablero t) {
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	    
        // A–ade los movimientos normales
		int paso;
		int incCol;
		int incFil;
        Pieza piezaPosDestino;      
        int[] incMov;
        boolean salir;
        
        // Procesa las 8 direcciones
        for (int i= 0; i<posiblesMovimientos.length; i++) {
        	incMov = posiblesMovimientos[i];
        	
        	// A–ade movimientos incrementando pasos en cada direcci—n
        	paso = 1;
        	salir = false;
        	do {
        		incCol = incMov[0]*paso;
        		incFil = incMov[1]*paso;
        		
        		// Si la posici—n est‡ fuera de tablero, sale
        		if(! t.estaDentro(posicion.getCol()+incCol, posicion.getFil()+incFil)) {
        			salir = true;
        		}
        		else  {
        			piezaPosDestino = t.obtenerPieza(posicion.getCol()+incCol, posicion.getFil()+incFil);
        			// Si la posici—n destino est‡ libre se a–ade como posible y continua
        			if(piezaPosDestino == null) {
            			movimientos.add(new Movimiento(posicion, incCol, incFil));
            		}
        			// Si en la posici—n destino hay una ficha de distinto color se a–ade como posible y sale
            		else if(piezaPosDestino.color != color) {
            			movimientos.add(new Movimiento(posicion, incCol, incFil));
            			salir = true;
            		}
        			// Si en la posici—n destino hay una ficha del mismo color, sale
            		else {
            			salir = true;
            		}
        		}
        		// Incrementa el contador de desplazamiento
        		paso++;
        	} while (! salir);
        }
		
		return movimientos;
	}
	
	@Override
	public boolean atacaPosicion(Tablero t, Posicion posicion) {
		// Obtiene los movimientos
		ArrayList<Movimiento> movimientos =  posiblesMovimientos(t);
		
		// Comprueba si dentro de la lista de movimientos est‡ la posici—n a comprobar.
		for(Movimiento m : movimientos) {
			if(posicion.equals(m.getDestino())) {
				return true;
			}
		}
				
		return false;
	}

	@Override
	public String getChar() {
		if(color == Constantes.BLANCAS)
			return Character.toString(Constantes.REINA);
		return  Character.toString(Constantes.REINA).toUpperCase();
	}

	@Override
	public Pieza clone() {
		return new Reina(posicion.clone(), color); 
	}
}
