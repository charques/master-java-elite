package edu.masterjava.javainiciacion.tarea20;

import java.util.ArrayList;

/**
 * Caballo de ajedrez
 * 
 * @author carloshernandezarques
 */
public class Caballo extends Pieza {
	
	// Posibles movimientos. Codifica pares de incrementos en (columna, fila)
    private static int[][] posiblesMovimientos = 
        {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};

	/**
	 * Contructor
	 * @param posicion
	 * @param color
	 */
	public Caballo(Posicion posicion, int color) {
		super(posicion, color);
	}

	@Override
	public ArrayList<Movimiento> posiblesMovimientos(Tablero t) {
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	    
        // A–ade los movimientos normales
        Pieza piezaPosDestino;      
        int incCol;
        int incFil;
        for (int i= 0; i<posiblesMovimientos.length; i++) {
        	incCol = posiblesMovimientos[i][0];
        	incFil = posiblesMovimientos[i][1];
        	if ( ! t.estaDentro(posicion.getCol()+incCol, posicion.getFil()+incFil)) 
            	continue;
            
            piezaPosDestino = t.obtenerPieza(posicion.getCol()+incCol, posicion.getFil()+incFil);
            if (piezaPosDestino == null || piezaPosDestino.color != color) {
            	movimientos.add(new Movimiento(posicion, incCol, incFil));
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
			return Character.toString(Constantes.CABALLO);
		return  Character.toString(Constantes.CABALLO).toUpperCase();
	}

	@Override
	public Pieza clone() {
		return new Caballo(posicion.clone(), color); 
	}
}
