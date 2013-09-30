/**
 * 
 */
package edu.masterjava.javainiciacion.tarea17;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clase que representa un tablero de 3 en raya
 * 
 * @author carloshernandezarques
 *
 */
public class Tablero {

	/**
	 * Lista de casillas.
	 */
	private List<Casilla> casillas;
	
	/**
	 * Contructor.
	 */
	public Tablero() {
		// Construye las casillas del tablero
		casillas = new ArrayList<Casilla>();
		for(int i = 0; i < 9; i++) {
			Casilla casilla = new Casilla(i);
			casillas.add(casilla);
		}
	}
	
	/**
	 * Coloca la ficha en la posicion especificada.
	 * Si la ficha se coloca con exito, devuelve true.
	 * Si la casilla ya est‡ ocupada devuelve false.
	 * @param pFicha
	 * @param pPosX
	 * @param pPosY
	 * @return
	 */
	public boolean colocarFicha(Ficha pFicha, int pPosX, int pPosY) {
		Casilla casilla = obtenerCasilla(pPosX, pPosY);
		if(casilla != null) {
			casilla.colocarFicha(pFicha);
			return true;
		}
		// La casilla est‡ ocupada.
		return false;
	}
	
	/**
	 * Indica si el tablero esta completo.
	 * @return
	 */
	public boolean estaCompleto() {
		return false;
	}
	
	/**
	 * Indica si hay tres en raya.
	 * Devuelve el id del jugador ganador.
	 * Devuelve -1 si no hay resultado.
	 * Devuelve 99 si hay tablas.
	 * Si hay un ganador, devuelve su identificador. 
	 * @return id del jugador ganador.
	 */
	public int checkTresEnRaya() {
		// horizontal 0
		int[] posiciones1 = {0,1,2};
		int combinacion1Result = checkFichas(posiciones1);
		if(combinacion1Result > 0)
			return combinacion1Result;
		
		// horizontal 1
		int[] posiciones2 = {3,4,5};
		int combinacion2Result = checkFichas(posiciones2);
		if(combinacion2Result > 0)
			return combinacion2Result;
		
		// horizontal 2
		int[] posiciones3 = {6,7,8};
		int combinacion3Result = checkFichas(posiciones3);
		if(combinacion3Result > 0)
			return combinacion3Result;
		
		// vertical 0
		int[] posiciones4 = {0,3,6};
		int combinacion4Result = checkFichas(posiciones4);
		if(combinacion4Result > 0)
			return combinacion4Result;
		
		// vertical 1
		int[] posiciones5 = {1,4,7};
		int combinacion5Result = checkFichas(posiciones5);
		if(combinacion5Result > 0)
			return combinacion5Result;
		
		// vertical 2
		int[] posiciones6 = {2,5,8};
		int combinacion6Result = checkFichas(posiciones6);
		if(combinacion6Result > 0)
			return combinacion6Result;
		
		// diagonal 0
		int[] posiciones7 = {0,4,8};
		int combinacion7Result = checkFichas(posiciones7);
		if(combinacion7Result > 0)
			return combinacion7Result;
		
		// diagonal 1
		int[] posiciones8 = {2,4,6};
		int combinacion8Result = checkFichas(posiciones8);
		if(combinacion8Result > 0)
			return combinacion8Result;
		
		if(checkTablas()) {
			return 99;
		}
		
		return -1;
	}
	
	/**
	 * Dibuja el tablero
	 */
	public void dibujar() {
		System.out.println("-------------");
		System.out.println("| " + dibujaFicha(0) + " | " + dibujaFicha(1) + " | " + dibujaFicha(2) + " |");
		System.out.println("-------------");
		System.out.println("| " + dibujaFicha(3) + " | " + dibujaFicha(4) + " | " + dibujaFicha(5) + " |");
		System.out.println("-------------");
		System.out.println("| " + dibujaFicha(6) + " | " + dibujaFicha(7) + " | " + dibujaFicha(8) + " |");
		System.out.println("-------------");
	}
	
	private String dibujaFicha(int posicion) {
		Casilla casilla = this.casillas.get(posicion);
		if(!casilla.estaLibre()) {
			Ficha ficha = casilla.getFicha();
			if(ficha.getJugador() == 1) {
				return "x";
			}
			return "o";
		}
		return " ";
	}
	
	/**
	 * Comprueba una lista de posiciones.
	 * Si hay fichas en todas las posiciones y el jugador es el mismo, devuelve 0.
	 * Si no hay fichas en todas las posiciones o el jugador es distinto en
	 * alguna de ellas, devuelve -1.
	 * @param posiciones
	 * @return
	 */
	private int checkFichas(int[] posiciones) {
		Ficha ficha;
		Casilla casilla;
		int jugadorReferencia = -1;
		for (int i = 0; i < posiciones.length; i++) {
			casilla = casillas.get(posiciones[i]);
			// la casilla no tiene ficha.
			if(casilla.estaLibre()) {
				return -1;
			}
			else {
				// la casilla tiene ficha
				ficha = casilla.getFicha();
				// coge el jugador de referencia
				if(jugadorReferencia == -1) {
					jugadorReferencia = ficha.getJugador();
				}
				// comprueba si las siguientes fichas pertenecen al mismo jugador
				else if(jugadorReferencia != ficha.getJugador()) {
					return -1;
				}
			}
		}
		// Si llega aqui, es porque se ha evaluado toda la lista de posiones
		// y todas contienen ficha y estas pertenecen al mismo jugador
		return jugadorReferencia;
	}
	
	/**
	 * Comprueba si hay tablas
	 * @return
	 */
	private boolean checkTablas() {
		Ficha ficha;
		for (int i = 0; i < casillas.size(); i++) {
			ficha = casillas.get(i).getFicha();
			if(ficha == null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return the casillas
	 */
	public List<Casilla> getCasillas() {
		return casillas;
	}
	
	/**
	 * Obtiene la casilla de la posicion especificada.
	 * Si la casilla est‡ ocupada devuelve null.
	 * @param pPosX
	 * @param pPosY
	 * @return
	 */
	private Casilla obtenerCasilla(int pPosX, int pPosY) {
		int posicion = calcularPosicion(pPosX, pPosY);
		Casilla casilla = casillas.get(posicion);
		if((casilla != null) && (casilla.estaLibre())) {
			return casilla;
		}
		return null;
	}
	
	/**
	 * Calcula la posicion de la casilla. 
	 * Transformando las cordenadas x,y que pueden tomar valores de 1 a 3, a
	 * un valor de posicion de 0 a 8.
	 * @param posX
	 * @param posY
	 * @return
	 */
	private int calcularPosicion(int posX, int posY) {
		return ((posY - 1) * 3) + (posX-1);
	}
	
	

}
