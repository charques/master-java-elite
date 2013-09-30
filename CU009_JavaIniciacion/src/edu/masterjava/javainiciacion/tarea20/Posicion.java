package edu.masterjava.javainiciacion.tarea20;

/**
 * Posici—n de una pieza formada por una fila y una columna.
 * 
 * @author carloshernandezarques
 */
public class Posicion {
    
    /** 
     * Columna 
     */
    private int col;

    /** 
     * Fila 
     */
    private int fil;
    
    /**
     * Constructor a partir de indice de columna y fila
     * @param columna 
     * @param fila 
     */
    public Posicion(int columna, int fila) {
        this.col = columna;
        this.fil = fila;
    }   
    
    /**
     * Constructor a partir de cadena de texto.
     * La cadena debe deter 2 caracteres. El primer 
     * caracter representa la columna y el segundo la fila.
     * Por ejemplo: "B1".
     * @param s
     */
    public Posicion(String s) {
        this(s.charAt(0)-'A', s.charAt(1)-'1');
    }
    
    /**
     * Clona la posici—n.
     */
    public Posicion clone() {
    	return new Posicion(col, fil);
    }
    
    /**
	 * Comprueba si 2 posiciones son iguales.
	 */
	public boolean equals(Object obj) {
		if ( this == obj ) 
			return true;
		if ( !(obj instanceof Posicion) ) 
			return false;
		Posicion pos = (Posicion) obj;
		return ((col == pos.col) && (fil == pos.fil));
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the fil
	 */
	public int getFil() {
		return fil;
	}

	/**
	 * @param fil the fil to set
	 */
	public void setFil(int fil) {
		this.fil = fil;
	}
    
    
}
