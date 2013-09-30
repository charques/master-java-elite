/**
 * 
 */
package edu.masterjava.javaintermedio.tarea17;

import edu.masterjava.javaintermedio.tarea15.ConsultaLoopPreparedStatementApp;
import edu.masterjava.javaintermedio.tarea16.ConsultaLoopStatementApp;


/**
 * 
 * Tarea 17. Modificar los dos ejercicios anteriores y 
 * medir el tiempo empleado en ambos. Sacar conclusiones.
 * 
 * @author carloshernandezarques
 * 
 */
public class ComparaTiemposApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConsultaLoopStatementApp.consultaTablaCorredoresStatement(500);
		ConsultaLoopPreparedStatementApp.consultaTablaCorredoresPreparedStatement(500);
	}

	/*
	 * RESULTADOS OBTENIDOS (500 consultas)
	 * ----------------------------------------
	 * consultaTablaCorredoresStatement:  700 milisegundos
	 * consultaTablaCorredoresPreparedStatement:  415 milisegundos
	 * -
	 * consultaTablaCorredoresStatement:  629 milisegundos
	 * consultaTablaCorredoresPreparedStatement:  373 milisegundos
	 * -
	 * consultaTablaCorredoresStatement:  669 milisegundos
	 * consultaTablaCorredoresPreparedStatement:  385 milisegundos
	 * 
	 * La prueba con PreparedStatement es sin duda mucho m‡s r‡pida en todas las pruebas
	 * realizadas. Esto est‡ justificado por la precompilaci—n de la query que realiza el
	 * objeto de tipo PreparedStatement.
	 */
	
}
