package edu.masterjava.javainiciacion.tarea20;

import java.util.ArrayList;

/**
 * Clase que representa un tablero
 * 
 * @author carloshernandezarques
 */
public class Tablero {

	private Pieza[][] tablero;
	private ArrayList<Movimiento> movimientosPosibles;
	private boolean hayJaque;
	private int turno;

	/**
	 * Constructor.
	 */
	public Tablero() {
		tablero = new Pieza[Constantes.FILAS][Constantes.COLUMNAS];
		colocaPiezas();
		
		this.hayJaque = false;
		this.turno = Constantes.BLANCAS;
		
		movimientosPosibles = generaMovimientos(turno);
	}
	
	/**
     * Constructor de tablero simulado
     * @param t Tablero a copiar
     */
    public Tablero(Tablero t) {
    	tablero = new Pieza[Constantes.FILAS][Constantes.COLUMNAS];
    	Pieza pieza;
    	for (int j = 0; j < Constantes.FILAS; j++) {
			for (int i = 0; i < Constantes.COLUMNAS; i++) {
				pieza = t.obtenerPieza(i, j);
				if(pieza != null) {
					pieza = pieza.clone();
					this.colocaPieza(i, j, pieza);
				}
            }
        }
    	hayJaque = t.hayJaque;
        turno = t.turno;
    }

	/**
	 * Coloca las piezas en el tablero en funci—n de la cadena
	 * Constantes.CONFIG_INICIAL.
	 */
	public void colocaPiezas() {
		String[] configuracionInicial = Constantes.CONFIG_INICIAL;
		Pieza pieza;
		char tipoPieza;
		for (int j = 0; j < Constantes.FILAS; j++) {
			for (int i = 0; i < Constantes.COLUMNAS; i++) {
				tipoPieza = configuracionInicial[j].charAt(i);
				pieza = PiezaFactory.creaPieza(tipoPieza, i, j);
				colocaPieza(i, j, pieza);
			}
		}
	}

	/**
	 * Coloca una pieza en la posici—n dada.
	 * @param col columna
	 * @param fil fila
	 * @param pieza pieza
	 */
	private void colocaPieza(int col, int fil, Pieza pieza) {
		tablero[fil][col] = pieza;
	}
	
	/**
	 * Obtiene la pieza de la posici—n dada.
	 * @param col columna
	 * @param fil fila
	 * @return pieza
	 */
	public Pieza obtenerPieza(int col, int fil) {
		return tablero[fil][col];
    }
	
	/**
	 * Indica si una posici—n del tablero est‡ vac’a.
	 * @param col
	 * @param fil
	 * @return
	 */
	public boolean estaVacia(int col, int fil) {
		Pieza pieza = obtenerPieza(col, fil);
		if(pieza != null) 
			return false;
		return true;
	}
	
	/**
	 * Indica si una posici—n est‡ dentro del tablero.
	 * @param col
	 * @param fil
	 * @return
	 */
	public boolean estaDentro(int col, int fil) {
		if((col >= 0) && (col < Constantes.COLUMNAS) && (fil >= 0) && (fil < Constantes.FILAS)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Mueve una pieza y devuelve un valor de estado
	 * @param turno jugador para el que se solicitan el calculo
	 * @param mov movimiento
	 * @return
	 */
	public int mover(Movimiento mov) {
		// Ejecuta el movimiento
		realizarMovimiento(mov);
			
		// Cambia el turno y genera los movimientos posibles
		cambiarTurno();
		movimientosPosibles = generaMovimientos(turno);
		
		// Comprueba si el rey del jugador que tiene el turno est‡ en jaque
		hayJaque = hayJaque();
		
		// Devuelve c—digo de estado
		if(hayJaque) {
			if(movimientosPosibles.size() > 0) {
				// Jaque
				return 1;
			}
			// Jaque mate
			return 2;
		}
		// ok
		return 0;
	}
	
	/**
	 * Ejecuta un movimiento, limpiando el origen y asignando la pieza a la posici—n
	 * destino.
	 * @param mov
	 */
	public void realizarMovimiento(Movimiento mov) {
		Pieza pieza = obtenerPieza(mov.getOrigen().getCol(), mov.getOrigen().getFil());
		//System.out.println("Movimiento " + pieza.getChar() + " " + mov.getOrigen().getCol() + " " + mov.getOrigen().getFil() + " " + mov.getDestino().getCol() + " " + mov.getDestino().getFil());
		
		// Coloca la pieza en el destino
		colocaPieza(mov.getDestino().getCol(), mov.getDestino().getFil(), pieza);
		pieza.setPosicion(mov.getDestino()); // Ajusta posici—n pieza
		// Limpia el origen
		colocaPieza(mov.getOrigen().getCol(), mov.getOrigen().getFil(), null);
	}
	
	/**
	 * Obtiene la posici—n del rey del turno pasado como par‡metro.
	 * @param turno
	 * @return
	 */
	private Posicion obtenerRey(int turno) {
		Pieza pieza;
        for (int j=0; j<Constantes.FILAS; j++) {
            for (int i=0; i<Constantes.COLUMNAS; i++) {
            	pieza = obtenerPieza(i,j);
                if (pieza != null && (pieza instanceof Rey) &&
                    pieza.getColor() == turno)
                {
                    return pieza.getPosicion();
                }
            }
        }
        return null;
	}
	
	/**
	 * Comprueba si el turno actual est‡ en jaque.
	 * @return
	 */
	public boolean hayJaque() {
		Posicion posicionRey = obtenerRey(turno);
		
		// Comprueba si las fichas contrarias atacan al rey
		Pieza pieza;
		for (int j=0; j < Constantes.FILAS; j++) {
            for (int i=0; i < Constantes.COLUMNAS; i++) {
            	pieza = obtenerPieza(i, j);
            	if((pieza != null) && (pieza.getColor() == obtenerTurnoContrario())) {
            		if(pieza.atacaPosicion(this, posicionRey)) {
            			return true;
            		}
            	}
            }
        }
		return false;
	}
	
	/**
	 * Cambia el turno de juego.
	 */
	private void cambiarTurno() {
		turno =  (turno == Constantes.BLANCAS) ? Constantes.NEGRAS : Constantes.BLANCAS;
	}
	
	/**
	 * Devuelve el turno contrario al actual.
	 * @return
	 */
	private int obtenerTurnoContrario() {
		return  (turno == Constantes.BLANCAS) ? Constantes.NEGRAS : Constantes.BLANCAS;
	}
	
	/**
	 * Calcula si un movimiento es posible para un jugador, en funci—n 
	 * de la configuraci—n actual del tablero.
	 * @param turno jugador para el que se solicitan el calculo
	 * @param mov movimiento
	 * @return 
	 */
	public boolean esMovimientoPosible(Movimiento mov) {
		for (Movimiento m : movimientosPosibles) {
			if(mov.equals(m)) {
				return true;
			}
		}
		return false;
	}
	
	/**
     * Genera una lista con los movimientos validos del jugador pasado como par‡metro, 
     * segœn la configuraci—n actual del tablero.
     * En estos movimientos posibles no est‡n los movimientos que generan una situaci—n
     * de jaque.
     * @param turno jugador para el que se solicitan los posibles movimientos.
	 * @return la lista de posibles movimientos.
     */    
    private ArrayList<Movimiento> generaMovimientos(int turno) {
    	ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        ArrayList<Movimiento> movimientosSinJaque = new ArrayList<Movimiento>();
        ArrayList<Movimiento> tempMovimientos;
        Pieza pieza;
        
        for (int j=0; j < Constantes.FILAS; j++) {
            for (int i=0; i < Constantes.COLUMNAS; i++) {
            	pieza = obtenerPieza(i, j);
            	// Obtiene la lista de movientos posibles para una pieza
            	// y lo a–ade a la lista de movimientos general.
            	if((pieza != null) && (pieza.getColor() == turno)) {
            		tempMovimientos = pieza.posiblesMovimientos(this);
            		movimientos.addAll(tempMovimientos);
            	}
            }
        }
        
        // Elimina los movimientos que generan una situaci—n de jaque.
        // Para cada movimiento, genera un tablero simulado, realiza el movimiento y
        // comprueba si el movimiento genera una situaci—n de jaque.
        for(Movimiento m : movimientos) {
        	Tablero tableroSimulado = new Tablero(this);
        	tableroSimulado.realizarMovimiento(m);
        	if(! tableroSimulado.hayJaque()) {
        		movimientosSinJaque.add(m);
        	}
        }
        
        return movimientosSinJaque;
    }
    
    /** 
     * Forma una cadena que representa la situaci—n actual del tablero.
     * @return la cadena.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Pieza pieza;
        
        sb.append("\n");
        // Dibuja el tablero, con coordenadas
        sb.append("   ");
        for (int i=0; i<Constantes.COLUMNAS; i++) {
            sb.append(" "+(char)('A'+i));
        }
        sb.append("\n");
        sb.append("   ");
        for (int i=0; i<Constantes.COLUMNAS; i++) {
            sb.append("__");
        }
        sb.append("\n");
        for (int j=Constantes.FILAS-1; j>=0; j--) {
            sb.append((char)('1'+j)+" | ");            
            for (int i=0; i<Constantes.COLUMNAS; i++) { 
            	pieza = obtenerPieza(i, j);
            	if(pieza != null) { 
            		sb.append(obtenerPieza(i, j).getChar() + " ");
            	}
            	else {
            		sb.append("  ");
            	}
            }
            sb.append("|\n");
        }
        sb.append("   ");
        for (int i=0; i<Constantes.COLUMNAS; i++) {
            sb.append("--");
        }
        if(hayJaque) {
        	sb.append("\nEn jaque: "+(hayJaque ? "si" : "no"));
        }
        sb.append("\n");
        
        return sb.toString();
    }       

	/**
	 * @return the turno
	 */
	public int getTurno() {
		return turno;
	}

    
}
