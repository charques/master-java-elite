/**
 * 
 */
package edu.masterjava.javaintermedio.tarea11;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.masterjava.javaintermedio.comun.JdbcComun;

/**
 * 
 * Tarea 11. Crear una aplicaci—n java que construya una tabla en una base de
 * datos, con campos de tipo texto, entero, bolean y fecha.
 * 
 * @author carloshernandezarques
 * 
 */
public class CreaTablaApp {
	
	static Statement stmt;
	static Connection con;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		creaTablaCorredores();
	}

	/**
	 * Crea la tabla de corredores
	 */
	public static void creaTablaCorredores() {
		Connection con = JdbcComun.getConnection();

		String createString;
		createString = "CREATE TABLE corredores (" +
				"corredor_id NUMBER(8), " +
				"nombre VARCHAR(30), " +
				"fecha_alta TIMESTAMP, " +
				"activo CHAR(1))";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			System.out.println("Tabla corredores creada.");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// no hace nada
			}
		}
		
	}

}
