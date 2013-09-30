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
 * Servlet implementation class SetNumberSessionServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/SetNumberSessionServlet?num=3
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/SetNumberSessionServlet")
public class SetNumberSessionServlet extends HttpServlet {
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
			// Procesa la entrada
			String numeroStr = request.getParameter("num");
			int numero = Integer.valueOf(numeroStr);
			
			// Guarda nœmero en la sesi—n
			HttpSession sesion = request.getSession();
			sesion.setAttribute("edu.masterjava.number", numero);
			
			out.println("<h3>Se ha almacenado el valor " + numero + " en la sesi—n.</h3>");
		}
		catch(NumberFormatException e) {
			out.println("<h3>Error: No se ha especificado el nœmero.</h3>");
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
