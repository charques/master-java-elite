package edu.masterjava.ajax.tarea01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 01. Obtiene la provincia en funci—n del nombre de usuario.
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/obtenerProvinciaServlet")
public class ObtenerProvinciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> map = null;
	
	public ObtenerProvinciaServlet() {
		map = new HashMap<String, String>();
		map.put("0", "Madrid");
		map.put("1", "Murcia");
		map.put("2", "Salamanca");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String usernameID = request.getParameter("username");
		String provincia = map.get(usernameID);
		
		if((provincia != null) && (provincia.length() > 0)) {
			out.println(provincia);
		}
		
		out.close();
	}

}
