package edu.masterjava.servlets.tarea02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 02. Crear un servlet que visualice en pantalla todos los par‡metros que
 * recibe. Tener en cuenta que es posible recibir varias veces el mismo
 * par‡metro.
 * 
 * Servlet implementation class ShowParametrosServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU011_Servlets/ShowParametrosServlet?prop=x&prop=r&test=valor1
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/ShowParametrosServlet")
public class ShowParametrosServlet extends HttpServlet {
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

		Map<String, String[]> mapa = request.getParameterMap();

		// recorre el mapa de parametros
		for (Entry<String, String[]> entry : mapa.entrySet()) {
			String[] values = entry.getValue();
			for (int i = 0; i < values.length; i++) {
				out.println("<br> Param : " + entry.getKey() + " : "
						+ entry.getValue()[i]);
			}
		}
		
		if(mapa.isEmpty()) {
			out.println("<br> No hay par‡metros.");
		}

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
