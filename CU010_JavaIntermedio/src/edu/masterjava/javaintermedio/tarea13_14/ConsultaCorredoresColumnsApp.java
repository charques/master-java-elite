/**
 * 
 */
package edu.masterjava.javaintermedio.tarea13_14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import edu.masterjava.javaintermedio.comun.JdbcComun;

/**
 * 
 * Tarea 14. Modificar el ejercicio anterior para que, mediante el metadata de
 * la consulta, muestre en pantalla una fila con el nombre de las columnas, y
 * debajo de ella los datos de la tabla.
 * 
 * @author carloshernandezarques
 * 
 */
public class ConsultaCorredoresColumnsApp {

	private static int longColumnas[] = {14, 15, 28, 7};
	
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

			ResultSetMetaData metadata = result.getMetaData();

			// Escribe la cabecera
			for (int i = 1; i <= metadata.getColumnCount(); i++)
				System.out.print(completarConEspacion(metadata.getColumnLabel(i), longColumnas[i-1]));
			System.out.println();

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
		bf.append(completarConEspacion(String.valueOf(id), longColumnas[0]));
		bf.append(completarConEspacion(nombre, longColumnas[1]));
		bf.append(completarConEspacion(alta.toString(), longColumnas[2]));
		bf.append(completarConEspacion(activo, longColumnas[3]));
		return bf.toString();
	}
	
	/**
	 * Completa con espacios hasta completar la longitud pasada como par‡metro.
	 * @param cadena
	 * @param longidud
	 */
	private static String completarConEspacion(String cadena, int longidud) {
		return String.format("%1$-" + longidud+ "s",cadena);
	}

}
