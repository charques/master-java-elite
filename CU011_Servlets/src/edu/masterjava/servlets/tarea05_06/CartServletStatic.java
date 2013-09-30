package edu.masterjava.servlets.tarea05_06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.masterjava.servlets.tarea05_06.dao.ProductsDAO;
import edu.masterjava.servlets.tarea05_06.dao.impl.StaticProductsDAOImpl;
import edu.masterjava.servlets.tarea05_06.model.Product;

/**
 * Tarea 05. Crear una aplicaci—n con carrito de la compra: un servlet 
 * mostrar‡ el carrito de la compra, otro listar‡ los productos, que al 
 * seleccionarlos se agregar‡n al carrito.
 * 
 * Servlet implementation class CartServletStatic
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/CartServletStatic
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/CartServletStatic")
public class CartServletStatic extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * DAO de productos
	 */
	private ProductsDAO productsDao;
	
	/**
	 * @see HttpServlet#init()
	 */
	public void init() {
		productsDao = new StaticProductsDAOImpl();
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
		
		// Escribe salida HTML
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Carro FotoTienda</h2>");
		
		// Escribe salida carro
		if(carroSesion.size() > 0) {
			out.print("<table cellpadding='10'>");
			out.print("<tr>");
			out.println("<td><b>Nombre</b></td>");
			out.println("<td><b>Precio</b></td>");
			out.println("<td><b>Unidades</b></td>");
			out.println("<td><b>Total</b></td>");
			out.print("</tr>");
			float totalCarro = 0;
			float totalProducto = 0;
			Product productoCarro = null;
			for(Map.Entry<String, Product> entry : carroSesion.entrySet()) {
				out.print("<tr>");
				productoCarro = entry.getValue();
				totalProducto = productoCarro.getPrecio() * productoCarro.getUnidadesCarro();
				totalCarro += totalProducto;
				out.println("<td>" + productoCarro.getNombre() + "</td>");
				out.println("<td>" + productoCarro.getPrecio() + " Û</td>");
				out.println("<td>" + productoCarro.getUnidadesCarro() + "</td>");
				out.println("<td>" + totalProducto + " Û</td>");
				out.print("</tr>");
			}	
			out.print("<tr><td></td></tr>");
			out.print("<tr><td><b>Total: " + totalCarro + " Û</b></td></tr>");
			out.print("</table>");
		}
		else {
			out.println("<h4>No hay productos en el carro.</h4>");
		}
		out.print("<a href='/CU011_Servlets/ProductsServletStatic'>Ver productos</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
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
