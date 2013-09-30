package edu.masterjava.servlets.tarea01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 01. Crear un servlet que recoja un par‡metro por pantalla y lo
 * visualice en la respuesta.
 * 
 * Servlet implementation class SimpleServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/Tarea01FormGet.html
 * http://localhost:8080/CU011_Servlets/Tarea01FormPost.html
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/ParametrosServlet")
public class ParametrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<br> Nombre: " + request.getParameter("nombre"));
		out.println("<br> Email: " + request.getParameter("email"));
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
