/**
 * 
 */
package edu.masterjava.jsp.tarea08.dao;

import java.sql.SQLException;

import edu.masterjava.jsp.tarea08.exceptions.UsuariosException;
import edu.masterjava.jsp.tarea08.model.Usuario;

/**
 * 
 * Interface del DAO de login.
 * 
 * @author carloshernandezarques
 *
 */
public interface UsuariosDAO {

	/**
	 * Recupera un usuario.
	 * @param username
	 * @return
	 * @throws UsuariosException
	 */
	public Usuario obtenerUsuario(String username) throws UsuariosException, SQLException;
	
	/**
	 * Crea una usuario
	 * @param username
	 * @param password
	 * @param nombre
	 * @throws UsuariosException
	 */
	public void creaUsuario(String username, String password, String nombre) throws UsuariosException, SQLException;
	
}
