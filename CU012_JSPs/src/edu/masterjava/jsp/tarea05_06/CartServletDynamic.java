package edu.masterjava.jsp.tarea05_06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.masterjava.jsp.tarea05_06.dao.ProductsDAO;
import edu.masterjava.jsp.tarea05_06.dao.impl.DynamicProductsDAOImpl;
import edu.masterjava.jsp.tarea05_06.model.Product;

/**
 * Tarea 05. Crear una aplicaci—n con carrito de la compra: un servlet 
 * mostrar‡ el carrito de la compra, otro listar‡ los productos, que al 
 * seleccionarlos se agregar‡n al carrito.
 * 
 * Servlet implementation class CartServletStatic
 * 
 * El script de bbdd : productos.sql
 * 
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU012_JSPs/index_tarea06.jsp
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/CartServletDynamic")
public class CartServletDynamic extends HttpServlet {
	
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

		// Se a–ade un producto al carro de sesion
		String idProductoAnadir = request.getParameter("add");
		if(idProductoAnadir != null) {
			int idProducto = Integer.valueOf(idProductoAnadir);
			Product producto = productsDao.detalleProducto(idProducto);
			anadirProductoCarro(request, producto);
		}
		
		// Obtiene el carro de la sesion
		Map<String, Product> carroSesion = obtenerCarroSesion(request);
		
		// Asigna la lista de productos a la request
		request.setAttribute("cart", carroSesion);
								
		// Obtiene el dispatcher
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea05/cart.jsp");
						
		// Hace forward para mostrar la lista de productos
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * A–ade un producto al carro.
	 * @param producto
	 */
	private void anadirProductoCarro(HttpServletRequest request, Product producto) {
		if(producto != null) {
			// Obtiene el carro
			Map<String, Product> cartMap = obtenerCarroSesion(request);
			
			String idProducto = String.valueOf(producto.getId());
			
			// A–ade un producto al carro
			if(!cartMap.containsKey(idProducto)) {
				producto.setUnidadesCarro(1);
				cartMap.put(idProducto, producto);
			}
			else {
				// Incrementa una unidad de producto
				Product productoCarro = cartMap.get(idProducto);
				productoCarro.setUnidadesCarro(productoCarro.getUnidadesCarro()+1);
				cartMap.put(idProducto, productoCarro);
			}
			
			// Guarda el carro
			HttpSession session = request.getSession();
			session.setAttribute("cart", cartMap);
		}
	}
	
	/**
	 * Obtiene el carro de la sesion
	 * @param request
	 * @return
	 */
	private Map<String, Product> obtenerCarroSesion(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Product> cartMap = (Map<String, Product>) session.getAttribute("cart");
		
		// Si no existe el carro en sesion, lo crea
		if(cartMap == null) {
			cartMap = new HashMap<String, Product>();
			session.setAttribute("cart", cartMap);
		}
		return cartMap;
	}

}
