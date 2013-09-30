package edu.masterjava.servlets.tarea03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 03. Crear un servlet que a partir de un formulario recoja un 
 * nœmero, y sea capaz de mostrar su tabla de multiplicar.
 * 
 * Servlet implementation class TablasServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/TablasServlet?num=3
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/TablasServlet")
public class TablasServlet extends HttpServlet {
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
			
			// Comprueba si el numero est‡ entre 1 y 10
			if(numero>=1 && numero<=10) {
				out.println("<h2>La tabla del " + numero + "</h2>");
				int calc = 0;
				for(int i = 1; i <= 10; i++) {
					calc = i*numero;
					out.println(numero + "x" + i + " = " + calc + "<br>");
				}
			}
			else {
				out.println("<h3>Error: El nœmero debe estar entre 1 y 10.</h3>");
			}
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
