package edu.masterjava.ajax.tarea04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 04. Procesa un formulario.
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/formularioServlet")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public FormularioServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		List<String> parameterNames = Collections.list(request.getParameterNames());
		
		if(!parameterNames.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			sb.append("<table>");
			
			for ( String parameterName:parameterNames) {
				sb.append("<tr>");
				sb.append("<td>");
				sb.append(parameterName);
				sb.append("</td>");
				sb.append("<td>");
				sb.append(request.getParameter(parameterName));
				sb.append("</td>");
				sb.append("</tr>");
			}
			
			sb.append("</table>");
			out.write(sb.toString());
		}
		
		out.close();
	}

}
