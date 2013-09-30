/**
 * 
 */
package edu.masterjava.servlets.tarea05_06.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.masterjava.servlets.tarea05_06.dao.ProductsDAO;
import edu.masterjava.servlets.tarea05_06.model.Product;

/**
 * 
 * Implementacion estatica del DAO de productos.
 * 
 * @author carloshernandezarques
 *
 */
public class StaticProductsDAOImpl implements ProductsDAO {

	private List<Product> productosTotal = new ArrayList<Product>();
	
	/**
	 * Constructor
	 */
	public StaticProductsDAOImpl() {
		Product producto1 = new Product();
		producto1.setId(1);
		producto1.setNombre("C‡mara Canon Ixus 230HS Plata");
		producto1.setDescripcion("Elegante y delgada, es la nueva c‡mara digital Canon Ixus 230HS en color plata. Gracias al objetivo zoom 8x y la capacidad para trabajar con poca luz del HS System.");
		producto1.setPrecio(159.5f);
		productosTotal.add(producto1);
		
		Product producto2 = new Product();
		producto2.setId(2);
		producto2.setNombre("C‡mara Superzoom Olympus SP810 UZ Negro");
		producto2.setDescripcion("La c‡mara Olympus con el zoom m‡s potente: la supersoom SP810 UZ. Presenta un objetivo zoom gran angular 1:2.9-5.7 24-864mm que es muy r‡pido y un sensor de imagen de 14 Megap’xeles que hacen de la SP-810UZ un objeto de deseo en su categor’a.");
		producto2.setPrecio(185.99f);
		productosTotal.add(producto2);
		
		Product producto3 = new Product();
		producto3.setId(3);
		producto3.setNombre("C‡mara Evil Olympus E-PM1 14-42mm Plata");
		producto3.setDescripcion("La vida es demasiado corta como para tener una c‡mara fea o que tenga menœs complicados o que no haga buenas fotos. Para no tener esos problemas hazte con la nueva Olympus PEN Mini.");
		producto3.setPrecio(299.0f);
		productosTotal.add(producto3);
	}
	
	
	@Override
	public List<Product> obtenerProductos() {
		return productosTotal;
	}
	
	@Override
	public Product detalleProducto(int idProducto) {
		for(Product item : productosTotal) {
			if(item.getId() == idProducto) {
				return item;
			}
		}
		return null;
	}

}
