package edu.masterjava.jsp.tarea07;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.jsp.comun.Utils;
import edu.masterjava.jsp.tarea07.dao.CatalogoDAO;
import edu.masterjava.jsp.tarea07.dao.impl.CatalogoDAOImpl;
import edu.masterjava.jsp.tarea07.exceptions.CatalogoException;
import edu.masterjava.jsp.tarea07.model.CatalogoItem;
import edu.masterjava.jsp.tarea07.model.Config;

/**
 * Tarea 07. Crear una aplicaci—n de gesti—n de cd's y dvd's de pel’culas 
 * y mœsica, que permita agregar nuevos, eliminar existentes, y listarlos.
 * 
 * Servlet implementation class ItemFormServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU012_JSPs/index_tarea07.jsp
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/itemForm")
public class ItemFormServlet extends HttpServlet {
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
		
		// Se procesa la accion
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		if(action.equals("new")) {
			showFormNewItem(request, response);
		}
		else if(action.equals("edit")) {
			showFormEditItem(id, request, response);
		}
		else  if(action.equals("delete")) {
			deleteItem(id, request, response);
		}
		else  if(action.equals("save")) {
			saveItem(request, response);
		}
		else {
			showFormNewItem(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Muestra el formulario de creaci—n.
	 * @param out
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showFormNewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		List<Config> tipos = catalogoDAO.obtenerTipos();
		List<Config> soportes = catalogoDAO.obtenerSoportes();

		// Asigna los tipos a la request
		request.setAttribute("tipos", tipos);

		// Asigna los soportes a la request
		request.setAttribute("soportes", soportes);
				
		// Obtiene el dispatcher dirigido al formulario
		dispatcher = getServletContext().getRequestDispatcher("/tarea07/itemform.jsp");
		
		// Hace forward
		dispatcher.forward(request, response);	
	}

	/**
	 * Muestra el formulario de edici—n.
	 * @param out
	 * @param itemId
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showFormEditItem(String itemId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		try {
			CatalogoItem item = catalogoDAO.detalleCatalogo(itemId);
			List<Config> tipos = catalogoDAO.obtenerTipos();
			List<Config> soportes = catalogoDAO.obtenerSoportes();
			
			// Asigna el item a la request
			if(item != null) {
				request.setAttribute("item", item);
			}
			
			// Asigna los tipos a la request
			request.setAttribute("tipos", tipos);

			// Asigna los soportes a la request
			request.setAttribute("soportes", soportes);
			
			// Obtiene el dispatcher dirigido al formulario
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/itemform.jsp");
		}
		catch(CatalogoException e) {
			// Obtiene el dispatcher dirigido a la pagina de error
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/error.jsp");
		}
		
		// Hace forward
		dispatcher.forward(request, response);	
	}
	
	/**
	 * Elimina un item.
	 * @param out
	 * @param itemId
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void deleteItem(String itemId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		try {
			catalogoDAO.eliminarItem(itemId);

			// Asigna el itemId a la request
			request.setAttribute("itemId", itemId);
			
			// Obtiene el dispatcher dirigido a la pagina de ok
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/deleteok.jsp");
		} catch (CatalogoException e) {
			// Obtiene el dispatcher dirigido a la pagina de error
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/error.jsp");
		}
		
		// Hace forward
		dispatcher.forward(request, response);	
	}
	
	/**
	 * Guarda un item.
	 * @param out
	 * @param request
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void saveItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			CatalogoItem item = new CatalogoItem();
			item.setId(Utils.convertirStringToInteger(request.getParameter("id")));
			item.setTitulo(request.getParameter("titulo"));
			item.setAutor(request.getParameter("autor"));
			item.setIdTipo(Utils.convertirStringToInteger(request.getParameter("tipo")));
			item.setIdSoporte(Utils.convertirStringToInteger(request.getParameter("soporte")));
			item.setAnio(Utils.convertirStringToInteger(request.getParameter("anio")));
			catalogoDAO.guardaItem(item);
			
			// Obtiene el dispatcher dirigido a la pagina de ok
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/saveok.jsp");
			
		} catch (CatalogoException e) {
			// Obtiene el dispatcher dirigido a la pagina de error
			dispatcher = getServletContext().getRequestDispatcher("/tarea07/error.jsp");
		}
		
		// Hace forward
		dispatcher.forward(request, response);	
	}
	
	

}
