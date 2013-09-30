/**
 * 
 */
package edu.masterjava.javaintermedio.tarea16;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.masterjava.javaintermedio.comun.JdbcComun;

/**
 * 
 * Tarea 16. Repetir el ejercicio anterior con un Statement.
 * 
 * @author carloshernandezarques
 * 
 */
public class ConsultaLoopStatementApp {

	static Statement stmt;
	static Connection con;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		consultaTablaCorredoresStatement(100);
	}

	/**
	 * Realiza el insert en la tabla de corredores
	 */
	public static void consultaTablaCorredoresStatement(int numLoops) {
		Connection con = JdbcComun.getConnection();

		try {
			long time;
			time = System.currentTimeMillis();
			
			String query = "SELECT corredor_id, nombre, fecha_alta, activo FROM corredores";
			stmt = con.createStatement();

			ResultSet result;
			for (int i = 0; i < numLoops; i++) {
				result = stmt.executeQuery(query);
			}
			
			time = System.currentTimeMillis() - time;
			System.out.println("consultaTablaCorredoresStatement:  " + time + " milisegundos");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// no hace nada
			}
		}
	}

}
