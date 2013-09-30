package edu.masterjava.comun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * Clase de utilizades comunes de tareas JDBC.
 * 
 * @author carloshernandezarques
 *
 */
public class JdbcConfig {
	
	private String url;
	private String usuario;
	private String password;
	
	
	/**
	 * Constructor.
	 * @param url
	 * @param usuario
	 * @param password
	 */
	public JdbcConfig(String url, String usuario, String password) {
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}
	
	/**
	 * Crea una conexi—n.
	 * @return
	 */
	public Connection getConnection() {

		Connection con = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
	}
	
	/**
	 * Cierra una conexion.
	 * @param con
	 */
	public void closeConnection(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
}
