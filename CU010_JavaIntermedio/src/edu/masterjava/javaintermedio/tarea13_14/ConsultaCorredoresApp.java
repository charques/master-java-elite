/**
 * 
 */
package edu.masterjava.javaintermedio.tarea13_14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import edu.masterjava.javaintermedio.comun.JdbcComun;

/**
 * 
 * Tarea 13. Realizar una consulta de dicha tabla y visualizar los datos de los
 * registros.
 * 
 * @author carloshernandezarques
 * 
 */
public class ConsultaCorredoresApp {

	static Statement stmt;
	static Connection con;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		consultaTablaCorredores();
	}

	/**
	 * Realiza la consulta a la tabla de corredores
	 */
	public static void consultaTablaCorredores() {
		Connection con = JdbcComun.getConnection();

		try {
			String query = "SELECT corredor_id, nombre, fecha_alta, activo FROM corredores";

			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);

			// Procesa los resultados
			while (result.next()) {
				int id = result.getInt(1);
				String nombre = result.getString(2);
				Timestamp alta = result.getTimestamp(3);
				String activo = result.getString(4);

				System.out
						.println(buildCorredorString(id, nombre, alta, activo));
			}

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

	/**
	 * Construye la cadena de texto con los datos de un corredor.
	 * 
	 * @param id
	 * @param nombre
	 * @param timestamp
	 * @param activo
	 * @return
	 */
	public static String buildCorredorString(int id, String nombre,
			Timestamp alta, String activo) {
		StringBuffer bf = new StringBuffer();
		bf.append("id: ");
		bf.append(id);
		bf.append(", nombre: ");
		bf.append(nombre);
		bf.append(", fecha_alta: ");
		bf.append(alta);
		bf.append(", activo: ");
		bf.append(activo);
		return bf.toString();
	}

}
