/**
 * 
 */
package edu.masterjava.struts.tarea03.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.masterjava.comun.JdbcConfig;
import edu.masterjava.comun.Utils;
import edu.masterjava.struts.tarea03.form.RegistroForm;
/**
 * @author carloshernandezarques
 *
 */
public class GestionUsuariosBO {

	JdbcConfig jdbcConfig = null;
	
	/**
	 * Constructor.
	 * @param cadenaConexion
	 * @param usuario
	 * @param password
	 */
	public GestionUsuariosBO(String cadenaConexion, String usuario, String password) {
		jdbcConfig = new JdbcConfig(cadenaConexion, usuario, password);
	}
	
	/**
	 * Registra un usuario.
	 * @param form
	 * @throws SQLException 
	 */
	public void registrar(RegistroForm form) throws SQLException {
		String query = "INSERT INTO usuarios_struts ";
		query += "VALUES ('" + form.getUsuario() + "', '" + form.getPassword()  + "', '" + form.getTelefono() +"')";
		
		try {
			Connection con = jdbcConfig.getConnection();
			Statement st = con.createStatement();
			st.execute(query);
			st.close();
			jdbcConfig.closeConnection(con);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
