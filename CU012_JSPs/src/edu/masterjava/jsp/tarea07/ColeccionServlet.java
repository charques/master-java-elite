package edu.masterjava.jsp.tarea07;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.jsp.tarea07.dao.CatalogoDAO;
import edu.masterjava.jsp.tarea07.dao.impl.CatalogoDAOImpl;
import edu.masterjava.jsp.tarea07.exceptions.CatalogoException;
import edu.masterjava.jsp.tarea07.model.CatalogoItem;

/**
 * Tarea 07. Crear una aplicaci—n de gesti—n de cd's y dvd's de pel’culas 
 * y mœsica, que permita agregar nuevos, eliminar existentes, y listarlos.
 * 
 * Servlet implementation class ColeccionServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU012_JSPs/index_tarea07.jsp
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/coleccion")
public class ColeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static CatalogoDAO catalogoDAO; 
	
	/**
	 * @see HttpServlet#init()
	 */
	public void init() {
		catalogoDAO = new CatalogoDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		
		// Obtiene el catalogo
		try {
			List<CatalogoItem> coleccion = null;
			coleccion = catalogoDAO.obtenerCatalogo(null);
			
			// Asigna la collection a la request
			request.setAttribute("coleccion", coleccion);
							
			// Obtiene el dispatcher dirigido a la pagina de coleccion
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/coleccion.jsp");
					
		} catch (CatalogoException e) {
			// Obtiene el dispatcher dirigido a la pagina de error
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/error.jsp");
		}
		
		// Hace forward
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
