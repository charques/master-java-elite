package edu.masterjava.javainiciacion.tarea20;

public class Constantes {

	 /** Configuraci—n inicial del tablero. Codifica todas las piezas del tablero como char
	  * por filas, empezando por la fila 1,2...8
	  *  en el orden A1, B1, C1 ... G8, H8 */
    //static final String CONFIG_INICIAL=
    	//"tcaqractpppppppp********************************PPPPPPPPTCAQRACT";
	
    static final String[] CONFIG_INICIAL= {"tcaqract","pppppppp","********", "********","********", "********","PPPPPPPP", "TCAQRACT"};
    
    /** 
     * Color blancas 
     */
    static final int BLANCAS=1;
    
    /** 
     * Color negras 
     */
    static final int NEGRAS=-1;
    
    /** 
     * Columnas del tablero 
     */
    static final int COLUMNAS=8;
    
    /** 
     * Filas del tablero 
     */
    static final int FILAS=8;    
    
	/** 
	 * Casilla vacia 
	 */
    static final char VACIA = '*';

    /** 
     * Peon blanco 
     */
    static final char PEON = 'p';
    
    /** 
     * Caballo blanco 
     */
    static final char CABALLO = 'c';
    
    /**
     * Alfil blanco
     */
    static final char ALFIL = 'a';
    
    /**
     * Torre blanca
     */
    static final char TORRE = 't';
    
    /**
     * Reina blanca
     */
    static final char REINA = 'q';
    
    /**
     * Rey blanco
     */
    static final char REY = 'r';

}
