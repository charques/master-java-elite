package edu.masterjava.ajax.tarea02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarea 02. Carga una p‡gina y devuelve el contenido.
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/cargarPaginaServlet")
public class CargaPaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CargaPaginaServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String page = request.getParameter("page");
		
		if((page != null) && (page.length() > 0)) {
			
			String protocol = request.getScheme();
			String host = request.getServerName();
			int port = request.getServerPort();
			String context = request.getContextPath();
			
			// Construye la URL
			StringBuffer sb = new StringBuffer();
			sb.append(protocol).append("://").append(host).append(":").append(port);
			sb.append(context).append("/").append(page).append(".html");
			URL url = new URL(sb.toString());
			
			// Lee la pagina HTML
			URLConnection con = url.openConnection();
			Reader r = new InputStreamReader(con.getInputStream(), "UTF-8");
			StringBuilder buf = new StringBuilder();
			while (true) {
			  int ch = r.read();
			  if (ch < 0)
			    break;
			  buf.append((char) ch);
			}
			String str = buf.toString();
			out.write(str);
		}
		
		out.close();
	}

}
