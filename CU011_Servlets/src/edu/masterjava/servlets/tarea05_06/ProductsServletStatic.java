package edu.masterjava.servlets.tarea05_06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.servlets.tarea05_06.dao.ProductsDAO;
import edu.masterjava.servlets.tarea05_06.dao.impl.StaticProductsDAOImpl;
import edu.masterjava.servlets.tarea05_06.model.Product;

/**
 * Tarea 05. Crear una aplicaci—n con carrito de la compra: un servlet 
 * mostrar‡ el carrito de la compra, otro listar‡ los productos, que al 
 * seleccionarlos se agregar‡n al carrito.
 * 
 * Servlet implementation class ProductsServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/ProductsServletStatic
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/ProductsServletStatic")
public class ProductsServletStatic extends HttpServlet {
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
		
		// Escribe salida
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>FotoTienda</h2>");

		// Obtiene productos
		List<Product> productos = productsDao.obtenerProductos();

		for(Product item : productos) {
			out.print("<h3>" + item.getNombre() + "</h3>");
			out.print("<p>" + item.getDescripcion() + "</p>");
			out.print("<h4>" + item.getPrecio() + " Û</h4>");
			out.print("<a href='/CU011_Servlets/CartServletStatic?add=" + item.getId() + "'>A–adir al carro</a>");
			out.print("<br/><br/>");
		}
		
		out.print("</br></br>");
		out.print("<a href='/CU011_Servlets/CartServletStatic'>Ir al carro</a>");
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

}
