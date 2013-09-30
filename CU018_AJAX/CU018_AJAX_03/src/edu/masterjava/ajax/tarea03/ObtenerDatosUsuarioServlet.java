package edu.masterjava.ajax.tarea03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 03. Obtiene los datos de usuario
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/obtenerDatosUsuarioServlet")
public class ObtenerDatosUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String,  List<String>> map = null;
	
	public ObtenerDatosUsuarioServlet() {
		map = new HashMap<String, List<String>>();
		map.put("0", new ArrayList<String>(Arrays.asList("Madrid", "Madrid", "C/ Mayor 14")));
		map.put("1", new ArrayList<String>(Arrays.asList("Murcia", "Molina de Segura", "C/ Roma 39")));
		map.put("2", new ArrayList<String>(Arrays.asList("Salamanca", "Santa Marta", "C/ Ribera 123")));
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String usernameID = request.getParameter("username");
		List<String> datos = map.get(usernameID);
		
		if(datos != null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<usuario>");
			sb.append("<provincia>");
			sb.append(datos.get(0));
			sb.append("</provincia>");
			sb.append("<ciudad>");
			sb.append(datos.get(1));
			sb.append("</ciudad>");
			sb.append("<direccion>");
			sb.append(datos.get(2));
			sb.append("</direccion>");
			sb.append("</usuario>");
			out.write(sb.toString());
		}
		
		out.close();
	}

}
