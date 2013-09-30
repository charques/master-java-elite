/**
 * 
 */
package edu.masterjava.struts.tarea11.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import edu.masterjava.comun.JdbcConfig;
import edu.masterjava.struts.tarea11.bo.model.Usuario;
import edu.masterjava.struts.tarea11.form.LoginForm;

/**
 * @author carloshernandezarques
 * 
 */
public class UsuariosBO {

	JdbcConfig jdbcConfig = null;

	/**
	 * Constructor.
	 * 
	 * @param cadenaConexion
	 * @param usuario
	 * @param password
	 */
	public UsuariosBO(String cadenaConexion, String usuario, String password) {
		jdbcConfig = new JdbcConfig(cadenaConexion, usuario, password);
	}

	/**
	 * Chequea el login de usuario.
	 * 
	 * @param form
	 * @throws SQLException
	 */
	public ActionMessages login(LoginForm form) throws SQLException {
		
		// Recupera el usuario.
		Usuario usuario = recuperarUsuario(form.getUsername());
		
		ActionMessages errors = new ActionMessages();
		
		// Comprueba si el usuario existe y las password sin iguales.
		if(usuario == null) {
			errors.add("usuError", new ActionMessage("error.usuarioErroneo"));
		}
		else if (!usuario.getPassword().equals(form.getPassword())) {
			errors.add("passError", new ActionMessage("error.passwordErronea"));
		}
		return errors;
	}
	
	/**
	 * Recupera los datos de usuario.
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	private Usuario recuperarUsuario(String username) throws SQLException {
		String query = "SELECT usuario, password FROM usuarios_struts WHERE usuario = '" + username + "'";
		Usuario usuario = null;
		
		// Realiza la consulta
		try {
			Connection con = jdbcConfig.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.execute();
			
			ResultSet rs = st.getResultSet();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
			}
			st.close();
			jdbcConfig.closeConnection(con);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return usuario;
	}
}
