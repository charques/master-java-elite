/**
 * 
 */
package edu.masterjava.javaintermedio.tarea15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.masterjava.javaintermedio.comun.JdbcComun;

/**
 * 
 * Tarea 15. Emplear un PreparedStatement para realizar 
 * un consulta contra la tabla anterior, repetir la 
 * consulta cien veces, pero sin crear de nuevo el objeto 
 * PreparedStatement.
 * 
 * @author carloshernandezarques
 * 
 */
public class ConsultaLoopPreparedStatementApp {

	static PreparedStatement stmt;
	static Connection con;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		consultaTablaCorredoresPreparedStatement(100);
	}

	/**
	 * Realiza el consulta en la tabla de corredores
	 */
	public static void consultaTablaCorredoresPreparedStatement(int numLoops) {
		Connection con = JdbcComun.getConnection();

		try {
			long time;
			time = System.currentTimeMillis();
			
			String query = "SELECT corredor_id, nombre, fecha_alta, activo FROM corredores";
			stmt = con.prepareStatement(query);
			
			ResultSet result;
			for (int i = 0; i < numLoops; i++) {
				result = stmt.executeQuery();
			}
			
			time = System.currentTimeMillis() - time;
			System.out.println("consultaTablaCorredoresPreparedStatement:  " + time + " milisegundos");

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
