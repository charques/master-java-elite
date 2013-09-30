package edu.masterjava.jsp.tarea05_06;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.jsp.tarea05_06.dao.ProductsDAO;
import edu.masterjava.jsp.tarea05_06.dao.impl.DynamicProductsDAOImpl;
import edu.masterjava.jsp.tarea05_06.model.Product;

/**
 * Tarea 05. Crear una aplicaci—n con carrito de la compra: un servlet 
 * mostrar‡ el carrito de la compra, otro listar‡ los productos, que al 
 * seleccionarlos se agregar‡n al carrito.
 * 
 * Servlet implementation class ProductsServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU012_JSPs/index_tarea06.jsp
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/productsDynamic")
public class ProductsServletDynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * DAO de productos
	 */
	private ProductsDAO productsDao;
	
	/**
	 * @see HttpServlet#init()
	 */
	public void init() {
		productsDao = new DynamicProductsDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Obtiene productos
		List<Product> productos = productsDao.obtenerProductos();
		
		// Asigna la lista de productos a la request
		request.setAttribute("productos", productos);
						
		// Obtiene el dispatcher
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea05/products.jsp");
				
		// Hace forward para mostrar la lista de productos
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
