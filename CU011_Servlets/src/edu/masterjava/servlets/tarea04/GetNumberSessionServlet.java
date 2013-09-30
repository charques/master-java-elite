package edu.masterjava.servlets.tarea04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Tarea 04. Crear un servlet que recoja como par‡metro un nœmero desde un formulario,
 *  y lo guarde en la sesi—n. Desde otro servlet sacar ese nœmero de la sessi—n y 
 *  mostrarlo en pantalla.
 * 
 * Servlet implementation class GetNumberSessionServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/GetNumberSessionServlet
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/GetNumberSessionServlet")
public class GetNumberSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		try {
			// Recupera el nœmero de la sesi—n
			HttpSession sesion = request.getSession();
			int numero = (Integer) sesion.getAttribute("edu.masterjava.number");
			
			out.println("<h3>Se ha recuperado el valor " + numero + " de la sesi—n.</h3>");
		}
		catch(NullPointerException e) {
			out.println("<h3>Error: El nœmero no est‡ almacena en sesi—n.</h3>");
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

}
