package edu.masterjava.servlets.tarea07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.servlets.comun.Utils;
import edu.masterjava.servlets.tarea05_06.model.Product;
import edu.masterjava.servlets.tarea07.dao.CatalogoDAO;
import edu.masterjava.servlets.tarea07.dao.impl.CatalogoDAOImpl;
import edu.masterjava.servlets.tarea07.exceptions.CatalogoException;
import edu.masterjava.servlets.tarea07.model.CatalogoItem;
import edu.masterjava.servlets.tarea07.model.Config;

/**
 * Tarea 07. Crear una aplicaci—n de gesti—n de cd's y dvd's de pel’culas 
 * y mœsica, que permita agregar nuevos, eliminar existentes, y listarlos.
 * 
 * Servlet implementation class ColeccionServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/ItemFormServlet
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/ItemFormServlet")
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
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		
		// Se procesa la accion
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		if(action.equals("new")) {
			showFormNewItem(out);
		}
		else if(action.equals("edit")) {
			showFormEditItem(out, id);
		}
		else  if(action.equals("delete")) {
			deleteItem(out, id);
		}
		else  if(action.equals("save")) {
			saveItem(out, request);
		}
		else {
			showFormNewItem(out);
		}
		
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
	 * Muestra el formulario de creaci—n.
	 * @param out
	 */
	private void showFormNewItem(PrintWriter out) {
		out.println("<h2>Nuevo Item</h2>");
		out.print("<form name='input' action='/CU011_Servlets/ItemFormServlet' method='get'>");
		out.print("<input type='hidden' name='action' value='save'>");
		out.print("Nombre: <input type='text' name='titulo'><br>");
		out.print("Autor: <input type='text' name='autor'><br>");
		out.print("A–o: <input type='text' name='anio'><br>");
		out.print("Tipo: <select name='tipo'>");
		List<Config> tipos = catalogoDAO.obtenerTipos();
		for(Config tipo : tipos) {
			out.print("<option value='" + tipo.getId() + "'>" + tipo.getDescripcion() + "</option>");
		}
		out.print("</select><br>");
		out.print("Soporte: <select name='soporte'>");
		List<Config> soportes = catalogoDAO.obtenerSoportes();
		for(Config soporte : soportes) {
			out.print("<option value='" + soporte.getId() + "'>" + soporte.getDescripcion() + "</option>");
		}
		out.print("</select><br><br>");
		out.print("<input type='submit' value='Guardar'>");
		out.print("<a href='/CU011_Servlets/ColeccionServlet'>Cancelar</a>");
		out.print("</form>");
	}

	/**
	 * Muestra el formulario de edici—n.
	 * @param out
	 * @param itemId
	 */
	private void showFormEditItem(PrintWriter out, String itemId) {
		
		try {
			CatalogoItem item = catalogoDAO.detalleCatalogo(itemId);
		
			out.print("<form name='input' action='/CU011_Servlets/ItemFormServlet' method='get'>");
			out.print("<input type='hidden' name='action' value='save'>");
			out.print("<input type='hidden' name='id' value='" + itemId + "'>");
			out.print("Nombre: <input type='text' name='titulo' value='" + item.getTitulo() + "'><br>");
			out.print("Autor: <input type='text' name='autor' value='" + item.getAutor() + "'><br>");
			out.print("A–o: <input type='text' name='anio' value='" + item.getAnio() + "'><br>");
			out.print("Tipo: <select name='tipo'>");
			List<Config> tipos = catalogoDAO.obtenerTipos();
			String selected = "";
			for(Config tipo : tipos) {
				selected = "";
				if(tipo.getId() == item.getIdTipo()) {
					selected = " selected='selected'";
				}
				out.print("<option" + selected + " value='" + tipo.getId() + "'>" + tipo.getDescripcion() + "</option>");
			}
			out.print("</select><br>");
			out.print("Soporte: <select name='soporte'>");
			List<Config> soportes = catalogoDAO.obtenerSoportes();
			for(Config soporte : soportes) {
				selected = "";
				if(soporte.getId() == item.getIdSoporte()) {
					selected = " selected='selected'";
				}
				out.print("<option" + selected + " value='" + soporte.getId() + "'>" + soporte.getDescripcion() + "</option>");
			}
			out.print("</select><br><br>");
			out.print("<input type='submit' value='Actualizar'>");
			out.print("<a href='/CU011_Servlets/ColeccionServlet'>Cancelar</a>");
			out.print("</form>");
		}
		catch(CatalogoException e) {
			out.println("<p>Ha ocurrido un error al obtener el detalle.</p>");
			out.print("<a href='/CU011_Servlets/ColeccionServlet'>Volver al cat‡logo</a>");
		}
	}
	
	/**
	 * Elimina un item.
	 * @param out
	 * @param itemId
	 */
	private void deleteItem(PrintWriter out, String itemId) {
		try {
			catalogoDAO.eliminarItem(itemId);
			out.println("<p>El item " + itemId + " se ha eliminado satisfactoriamente.</p>");
		} catch (CatalogoException e) {
			out.println("<p>Ha ocurrido un error al eliminar.</p>");
		}
		out.print("<a href='/CU011_Servlets/ColeccionServlet'>Volver al cat‡logo</a>");
	}
	
	/**
	 * Guarda un item.
	 * @param out
	 * @param request
	 */
	private void saveItem(PrintWriter out, HttpServletRequest request) {
		try {
			CatalogoItem item = new CatalogoItem();
			item.setId(Utils.convertirStringToInteger(request.getParameter("id")));
			item.setTitulo(request.getParameter("titulo"));
			item.setAutor(request.getParameter("autor"));
			item.setIdTipo(Utils.convertirStringToInteger(request.getParameter("tipo")));
			item.setIdSoporte(Utils.convertirStringToInteger(request.getParameter("soporte")));
			item.setAnio(Utils.convertirStringToInteger(request.getParameter("anio")));
			catalogoDAO.guardaItem(item);
			out.println("<p>El item se ha guardado satisfactoriamente.</p>");
		} catch (CatalogoException e) {
			out.println("<p>Ha ocurrido un error al guardar el item.</p>");
		}
		out.print("<a href='/CU011_Servlets/ColeccionServlet'>Volver al cat‡logo</a>");
	}
	
	

}
