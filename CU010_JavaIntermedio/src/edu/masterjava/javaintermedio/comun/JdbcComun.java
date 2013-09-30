package edu.masterjava.javaintermedio.comun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilizades comunes de tareas JDBC.
 * 
 * @author carloshernandezarques
 *
 */
public class JdbcComun {

	static String url = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
	final static String USUARIO = "charques";
	final static String PASSWORD = "Manolete1";
	
	/**
	 * Crea una conexi—n.
	 * @return
	 */
	public static Connection getConnection() {

		Connection con = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection(url, USUARIO, PASSWORD);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return con;
	}
	
}
