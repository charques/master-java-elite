/**
 * 
 */
package edu.masterjava.struts.tarea15.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.masterjava.comun.JdbcConfig;

/**
 * @author carloshernandezarques
 * 
 */
public class DataBaseBO {

	JdbcConfig jdbcConfig = null;

	/**
	 * Constructor.
	 * 
	 * @param cadenaConexion
	 * @param usuario
	 * @param password
	 */
	public DataBaseBO(String cadenaConexion, String usuario, String password) {
		jdbcConfig = new JdbcConfig(cadenaConexion, usuario, password);
	}

	/**
	 * Chequea el login de usuario.
	 * 
	 * @param form
	 * @throws SQLException
	 */
	public Map<String, List<String>> ejecutaQuery(String query)
			throws SQLException {

		Map<String, List<String>> filas = new HashMap<String, List<String>>();

		// Realiza la consulta
		try {
			Connection con = jdbcConfig.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.execute();

			ResultSet rs = st.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			List<String> valores = null;

			// A–ade filas de datos
			int index = 0;
			if (rs.next()) {
				valores = new ArrayList<String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					valores.add(rs.getObject(i).toString());
				}
				filas.put(String.valueOf(index), valores);
				index++;
			}

			// A–ade fila cabecera
			valores = new ArrayList<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				valores.add(rsmd.getColumnName(i));
			}
			filas.put(String.valueOf(index), valores);

			st.close();
			jdbcConfig.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return filas;
	}

	/**
	 * Recupera la lista de nombres de tablas.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<String> obtenerTablas() throws SQLException {

		List<String> tablas = new ArrayList<String>();

		String query = "SELECT table_name FROM dba_tables WHERE owner = 'CHARQUES'";

		// Realiza la consulta
		try {
			Connection con = jdbcConfig.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.execute();

			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				tablas.add(rs.getString("table_name"));
			}
			st.close();
			jdbcConfig.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return tablas;
	}
	
	/**
	 * Obtiene la descripcion de una tabla.
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public List<String> obtenerDescTabla(String tableName) throws SQLException {

		List<String> columnas = new ArrayList<String>();

		String query = "SELECT * FROM " + tableName +" WHERE 0 = 1";

		// Realiza la consulta
		try {
			Connection con = jdbcConfig.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.execute();

			ResultSet rs = st.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				StringBuffer sb = new StringBuffer();
				sb.append(rsmd.getColumnName(i));
				sb.append(" Type: " + rsmd.getColumnTypeName(i));
				sb.append(" Size: " + rsmd.getColumnDisplaySize(i));
				columnas.add(sb.toString());
			}
			
			st.close();
			jdbcConfig.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return columnas;
	}
	
	

}
