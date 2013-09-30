package edu.masterjava.javainiciacion.tarea20;

/**
 * Factoria de piezas
 * 
 * @author carloshernandezarques
 */
public class PiezaFactory {

	/**
	 * MŽtodo de creaci—n de piezas en funci—n de su tipo (char)
	 * @param tipoPieza
	 * @param columna
	 * @param fila
	 * @return
	 */
	public static Pieza creaPieza(char tipoPieza, int columna, int fila) {
		int color = Character.isLowerCase(tipoPieza) ? Constantes.BLANCAS : Constantes.NEGRAS;
        
        switch(Character.toLowerCase(tipoPieza)) {
            case Constantes.REY:
                return new Rey(new Posicion(columna, fila), color);
            case Constantes.CABALLO:
            	return new Caballo(new Posicion(columna, fila), color);
            case Constantes.ALFIL:
            	return new Alfil(new Posicion(columna, fila), color);
            case Constantes.TORRE:
            	return new Torre(new Posicion(columna, fila), color);
            case Constantes.REINA:
            	return new Reina(new Posicion(columna, fila), color);
            case Constantes.PEON:  
                return new Peon(new Posicion(columna, fila), color);
                
            case Constantes.VACIA: 
                return null;
        }
        
        return null;
    }

}
