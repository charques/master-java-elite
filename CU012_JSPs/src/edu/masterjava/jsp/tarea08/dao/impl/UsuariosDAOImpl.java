/**
 * 
 */
package edu.masterjava.jsp.tarea08.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.masterjava.jsp.comun.JdbcComun;
import edu.masterjava.jsp.comun.Utils;
import edu.masterjava.jsp.tarea08.dao.UsuariosDAO;
import edu.masterjava.jsp.tarea08.exceptions.UsuariosException;
import edu.masterjava.jsp.tarea08.model.Usuario;

/**
 * Implementacion del DAO de login
 * 
 * @author carloshernandezarques
 * 
 */
public class UsuariosDAOImpl implements UsuariosDAO {

	@Override
	public Usuario obtenerUsuario(String username)
			throws UsuariosException, SQLException {

		// TODO: validacion

		Usuario usuario = null;
		try {
			// obtiene el usuario
			Connection con = JdbcComun.getConnection();
			String insertString = "SELECT username, password, nombre FROM usuarios WHERE username = ?";
			PreparedStatement stmt = con.prepareStatement(insertString);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setUsername(rs.getString("username"));
				usuario.setPasswordMd5(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				break;
			}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw e;
		}
		
		return usuario;
	}

	@Override
	public void creaUsuario(String username, String password, String nombre)
			throws UsuariosException, SQLException {

		// TODO: validacion

		String passwordMd5 = null;
		try {
			// codifica password
			passwordMd5 = Utils.encriptarPassword(password);
			if(Utils.esNuloVacio(passwordMd5)) {
				throw new UsuariosException(UsuariosException.ERROR_CREA_USUARIO_CODE);
			}

			// inserta nuevo usuario
			Connection con = JdbcComun.getConnection();
			String insertString = "INSERT INTO usuarios VALUES(?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(insertString);
			stmt.setString(1, username);
			stmt.setString(2, passwordMd5);
			stmt.setString(3, nombre);
			stmt.executeUpdate();

			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			throw e;
		}
	}

}
