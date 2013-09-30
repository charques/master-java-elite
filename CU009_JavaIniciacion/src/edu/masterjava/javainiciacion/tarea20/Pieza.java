package edu.masterjava.javainiciacion.tarea20;

import java.util.ArrayList;

/**
 * Pieza de ajedrez
 * 
 * @author carloshernandezarques
 */
public abstract class Pieza {

	/** 
	 * Posicion de la pieza 
	 */
    protected Posicion posicion;
    
    /** 
     * Color de la pieza (BLANCO o NEGRO) 
     */
    protected int color;
	
	/**
	 * Constructor
	 * @param posicion Posici—n de la pieza
	 * @param color Color de la pieza
	 */
	public Pieza(Posicion posicion, int color) {
        this.posicion = posicion;
        this.color = color;
    }
	
	/**
	 * Crea una copia de una pieza.
	 */
	public abstract Pieza clone();
	
	/**
	 * @return the posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * Devuelve el caracter que reprenta la pieza.
	 * @return
	 */
	public abstract String getChar();
	
	/**
	 * Indica si una pieza ataca una posici—n pasada como par‡metro.
	 * @param posicion
	 */
	public abstract boolean atacaPosicion(Tablero t, Posicion posicion);

	/** 
     * Genera todos los posibles movimientos para esta pieza en este tablero.
     * @param t tablero
     * @return movimientos
     */
    public abstract ArrayList<Movimiento> posiblesMovimientos(Tablero t);
}
