/**
 * 
 */
package edu.masterjava.javaintermedio.tarea12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import edu.masterjava.javaintermedio.comun.JdbcComun;

/**
 * 
 * Tarea 12. Insertar varios registros en la tabla 
 * realizada en el ejercicio anterior.
 * 
 * @author carloshernandezarques
 * 
 */
public class AnadirCorredoresApp {
	
	static PreparedStatement stmt;
	static Connection con;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		insertTablaCorredores(34);
	}

	/**
	 * Realiza el insert en la tabla de corredores
	 */
	public static void insertTablaCorredores(int numCorredores) {
		Connection con = JdbcComun.getConnection();
		
		try {
			String query = "INSERT INTO corredores(corredor_id, nombre, fecha_alta, activo) values (?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			
			int i;
			for(i = 0; i < numCorredores; i++) {
				stmt.setInt(1, i);
				stmt.setString(2, "corredor " + i);
				stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
				stmt.setString(4, "S");
				stmt.executeUpdate();
			}
			System.out.println(i + " corredores insertados.");

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
