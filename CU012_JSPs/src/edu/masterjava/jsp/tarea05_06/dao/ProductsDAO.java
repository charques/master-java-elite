/**
 * 
 */
package edu.masterjava.jsp.tarea05_06.dao;

import java.util.List;

import edu.masterjava.jsp.tarea05_06.model.Product;

/**
 * 
 * Interface del DAO de acceso a productos.
 * 
 * @author carloshernandezarques
 *
 */
public interface ProductsDAO {

	/**
	 * Obtiene los productos de la tienda.
	 * @return
	 */
	public List<Product> obtenerProductos();
	
	
	/**
	 * Detalle de producto.
	 * @param id
	 * @return
	 */
	public Product detalleProducto(int idProducto);
}
