package edu.masterjava.ejb.tarea01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEjbClient
 * 
 * URL prueba:
 * http://localhost:8080/cu013-tarea01-web/ServletEjbClient
 * 
 */
@WebServlet("/ServletEjbClient")
public class ServletEjbClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    StringsBeanLocal bean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjbClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String texto = bean.convertirMayusculas("EJBs Tarea01 - Prueba Cliente Local Servlet");
		System.out.println(texto);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<br>" + texto);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
