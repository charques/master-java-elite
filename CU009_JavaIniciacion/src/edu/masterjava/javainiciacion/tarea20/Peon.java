package edu.masterjava.javainiciacion.tarea20;

import java.util.ArrayList;

/**
 * Pe—n de ajedrez
 * 
 * @author carloshernandezarques
 */
public class Peon extends Pieza {

	/**
	 * Contructor
	 * @param posicion
	 * @param color
	 */
	public Peon(Posicion posicion, int color) {
		super(posicion, color);
	}

	@Override
	public ArrayList<Movimiento> posiblesMovimientos(Tablero t) {
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		
		int incFil = (color==Constantes.BLANCAS) ? 1 : -1;
		
		// El peon avanza una posici—n
		if(t.estaVacia(posicion.getCol(), posicion.getFil() + incFil)) 
		{
			movimientos.add(new Movimiento(posicion, 0, incFil));
			
			// El pe—n avanza 2 posiciones
			if(t.estaVacia(posicion.getCol(), posicion.getFil() + (incFil*2))) 
			{
				movimientos.add(new Movimiento(posicion, 0, incFil*2));
			}
		}
		
		// Diagonal izquierda
		int incCol = (color==Constantes.BLANCAS) ? -1 : 1;
		if(t.estaDentro(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   ! t.estaVacia(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   t.obtenerPieza(posicion.getCol() + incCol, posicion.getFil() + incFil).getColor() != color) 
		{
			movimientos.add(new Movimiento(posicion, incCol, incFil));
		}
		
		// Diagonal derecha
		incCol = (color==Constantes.BLANCAS) ? 1 : -1;
		if(t.estaDentro(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   ! t.estaVacia(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   t.obtenerPieza(posicion.getCol() + incCol, posicion.getFil() + incFil).getColor() != color) 
		{
			movimientos.add(new Movimiento(posicion, incCol, incFil));
		}
		
		return movimientos;
	}
	
	@Override
	public boolean atacaPosicion(Tablero t, Posicion posicion) {
		// Genera los movimientos de ataque del peon
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		
		int incFil = (color==Constantes.BLANCAS) ? 1 : -1;
		// Diagonal izquierda
		int incCol = (color==Constantes.BLANCAS) ? -1 : 1;
		if(t.estaDentro(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   ! t.estaVacia(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   t.obtenerPieza(posicion.getCol() + incCol, posicion.getFil() + incFil).getColor() != color) 
		{
			movimientos.add(new Movimiento(posicion, incCol, incFil));
		}
		
		// Diagonal derecha
		incCol = (color==Constantes.BLANCAS) ? 1 : -1;
		if(t.estaDentro(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   ! t.estaVacia(posicion.getCol() + incCol, posicion.getFil() + incFil) &&
		   t.obtenerPieza(posicion.getCol() + incCol, posicion.getFil() + incFil).getColor() != color) 
		{
			movimientos.add(new Movimiento(posicion, incCol, incFil));
		}
		
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
			return Character.toString(Constantes.PEON);
		return  Character.toString(Constantes.PEON).toUpperCase();
	}

	@Override
	public Pieza clone() {
		return new Peon(posicion.clone(), color); 
	}

	
	
}
