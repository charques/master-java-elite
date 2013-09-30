package edu.masterjava.servlets.tarea07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.servlets.tarea07.dao.CatalogoDAO;
import edu.masterjava.servlets.tarea07.dao.impl.CatalogoDAOImpl;
import edu.masterjava.servlets.tarea07.exceptions.CatalogoException;
import edu.masterjava.servlets.tarea07.model.CatalogoItem;

/**
 * Tarea 07. Crear una aplicaci—n de gesti—n de cd's y dvd's de pel’culas 
 * y mœsica, que permita agregar nuevos, eliminar existentes, y listarlos.
 * 
 * Servlet implementation class ColeccionServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/ColeccionServlet
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/ColeccionServlet")
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
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cat‡logo</h2>");
		out.println("<hr>");
		out.println("<a href='/CU011_Servlets/ItemFormServlet?action=new'>A–adir item</a>");
		out.println("<hr>");
		
		// Obtiene el catalogo
		try {
			List<CatalogoItem> catalogo = null;
			catalogo = catalogoDAO.obtenerCatalogo(null);
			
			// Muestra el catalogo
			if(catalogo.size() > 0) {
				out.print("<table cellpadding='10'>");
				out.print("<tr>");
				out.println("<td><b>Titulo</b></td>");
				out.println("<td><b>Autor</b></td>");
				out.println("<td><b>Tipo</b></td>");
				out.println("<td><b>Soporte</b></td>");
				out.println("<td><b>A–o</b></td>");
				out.println("<td></td>");
				out.println("<td></td>");
				out.print("</tr>");
				
				for(CatalogoItem item : catalogo) {
					out.print("<tr>");
					out.println("<td>" + item.getTitulo() + "</td>");
					out.println("<td>" + item.getAutor() + "</td>");
					out.println("<td>" + item.getDescripTipo() + "</td>");
					out.println("<td>" + item.getDescripSoporte() + "</td>");
					out.println("<td>" + item.getAnio() + "</td>");
					out.println("<td><a href='/CU011_Servlets/ItemFormServlet?action=edit&id=" + item.getId() +"'>Editar</a></td>");
					out.println("<td><a href='/CU011_Servlets/ItemFormServlet?action=delete&id=" + item.getId() +"'>Eliminar</a></td>");
					out.print("</tr>");
				}
				out.print("<tr><td></td></tr>");
				out.print("</table>");
			}
			else {
				out.println("<h4>No hay elementos en el cat‡logo.</h4>");
			}
		} catch (CatalogoException e) {
			out.println("Ha ocurrido un error al obtener el cat‡logo.");
		}
		
		out.println("<hr>");
		out.println("<a href='/CU011_Servlets/ItemFormServlet?action=new'>A–adir item</a>");
		out.println("<hr>");
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
