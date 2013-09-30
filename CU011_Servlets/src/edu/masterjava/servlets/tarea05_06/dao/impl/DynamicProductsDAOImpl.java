/**
 * 
 */
package edu.masterjava.servlets.tarea05_06.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.masterjava.servlets.comun.JdbcComun;
import edu.masterjava.servlets.tarea05_06.dao.ProductsDAO;
import edu.masterjava.servlets.tarea05_06.model.Product;

/**
 * 
 * Implementacion dinamica del DAO de productos.
 * 
 * @author carloshernandezarques
 *
 */
public class DynamicProductsDAOImpl implements ProductsDAO {

	@Override
	public List<Product> obtenerProductos() {
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		List<Product> productos = new ArrayList<Product>();
		
		try {
			String query = "SELECT id_prod, nombre, descripcion, precio FROM productos";
			stmt = con.prepareStatement(query);
			
			ResultSet result = stmt.executeQuery();
			
			Product producto;
			while (result.next()) {
				int id = result.getInt(1);
				String nombre = result.getString(2);
				String descripcion = result.getString(3);
				float precio = result.getFloat(4);

				producto = new Product();
				producto.setId(id);
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(precio);
				productos.add(producto);
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
		return productos;
	}

	@Override
	public Product detalleProducto(int idProducto) {
		Connection con = JdbcComun.getConnection();
		PreparedStatement stmt = null;
		Product producto = null;
		
		try {
			String query = "SELECT id_prod, nombre, descripcion, precio FROM productos WHERE id_prod= ?";
			stmt = con.prepareStatement(query);
			stmt.setFloat(1, idProducto);
			
			ResultSet result = stmt.executeQuery();
			
			
			while (result.next()) {
				int id = result.getInt(1);
				String nombre = result.getString(2);
				String descripcion = result.getString(3);
				float precio = result.getFloat(4);

				producto = new Product();
				producto.setId(id);
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(precio);
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
		return producto;
	}

}
