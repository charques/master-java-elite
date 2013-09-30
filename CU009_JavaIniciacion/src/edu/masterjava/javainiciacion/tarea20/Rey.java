package edu.masterjava.javainiciacion.tarea20;

import java.util.ArrayList;

/**
 * Rey de ajedrez
 * 
 * @author carloshernandezarques
 */
public class Rey extends Pieza {
	
	// Posibles movimientos. Codifica pares de incrementos en (columna, fila)
    private static int[][] posiblesMovimientos = 
        {{1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}};

	/**
	 * Contructor
	 * @param posicion
	 * @param color
	 */
	public Rey(Posicion posicion, int color) {
		super(posicion, color);
	}

	@Override
	public ArrayList<Movimiento> posiblesMovimientos(Tablero t) {
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	    
        // A–ade los movimientos normales
        Pieza piezaPosDestino;      
        int[] incMov;
        for (int i= 0; i<posiblesMovimientos.length; i++) {
        	incMov = posiblesMovimientos[i];
            if ( ! t.estaDentro(posicion.getCol()+incMov[0], posicion.getFil()+incMov[1])) 
            	continue;
            
            piezaPosDestino = t.obtenerPieza(posicion.getCol()+incMov[0], posicion.getFil()+incMov[1]);
            if (piezaPosDestino == null || piezaPosDestino.color != color) {
            	movimientos.add(new Movimiento(posicion, incMov[0], incMov[1]));
            }
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
			return Character.toString(Constantes.REY);
		return  Character.toString(Constantes.REY).toUpperCase();
	}

	@Override
	public Pieza clone() {
		return new Rey(posicion.clone(), color); 
	}

	
}
