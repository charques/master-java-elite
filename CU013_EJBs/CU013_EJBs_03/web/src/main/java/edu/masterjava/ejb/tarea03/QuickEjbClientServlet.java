package edu.masterjava.ejb.tarea03;

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
 * http://localhost:8080/cu013-tarea03-web/QuickEjbClientServlet
 * 
 */
@WebServlet("/QuickEjbClientServlet")
public class QuickEjbClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    StateTestBeanLocal beanLocal;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuickEjbClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		beanLocal.setValue(20);
		int valor = beanLocal.getValue();
		System.out.println("valor: " + valor);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<br>" + valor);
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
