/**
 * 
 */
package edu.masterjava.jsp.tarea08.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.masterjava.jsp.comun.Utils;
import edu.masterjava.jsp.tarea08.dao.UsuariosDAO;
import edu.masterjava.jsp.tarea08.dao.impl.UsuariosDAOImpl;
import edu.masterjava.jsp.tarea08.exceptions.UsuariosException;
import edu.masterjava.jsp.tarea08.model.Usuario;

/**
 * @author carloshernandezarques
 * 
 */
public class UsuariosDAOTest {

	UsuariosDAO loginDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		loginDAO = new UsuariosDAOImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		loginDAO = null;
	}

	/**
	 * Test method for
	 * {@link edu.masterjava.jsp.tarea08.dao.impl.UsuariosDAOImpl#obtenerUsuario(java.lang.String)}
	 * .
	 */
	@Test
	public void testObtenerUsuarioExito() {
		Usuario usuario = null;
		try {
			String username = "admin";
			usuario = loginDAO.obtenerUsuario(username);
		}
		catch(UsuariosException e) {
			fail(e.getCode());
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		assertNotNull(usuario);
	}
	
	/**
	 * Test method for
	 * {@link edu.masterjava.jsp.tarea08.dao.impl.UsuariosDAOImpl#obtenerUsuario(java.lang.String)}
	 * .
	 */
	@Test
	public void testObtenerUsuarioNoExiste() {
		Usuario usuario = null;
		try {
			String username = "xxx";
			usuario = loginDAO.obtenerUsuario(username);
		}
		catch(UsuariosException e) {
			fail(e.getMessage());
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		assertNull(usuario);
	}

	/**
	 * Test method for
	 * {@link edu.masterjava.jsp.tarea08.dao.impl.UsuariosDAOImpl#creaUsuario(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testCreaUsuario() {
		try {
			String username = Utils.generateRandomString(8);
			String password = Utils.generateRandomString(8);
			String nombre = "Usuario test";
			loginDAO.creaUsuario(username, password, nombre);
		}
		catch(UsuariosException e) {
			fail(e.getCode());
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		assertTrue(true);
	}
}
