package edu.masterjava.ejb.tarea010;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.ejb.tarea10.bean.Ejb1Local;

/**
 * Servlet implementation class TestServlet
 * 
 * URL prueba:
 * http://localhost:8080/cu013-tarea10-web/test
 * 
 *
 * -------------------------------------------------
 * Resultados
 * -------------------------------------------------
 * CASO 1:
 *    	- usuario: user1 - password: test - rol: rolBueno
 *     	- Se ejecuta correctamente. No lanza excepcion
 * CASO 2:
 * 		- usuario: user2 - password: test - rol: rolMalo
 * 		- Invocation on method: public abstract void edu.masterjava.ejb.tarea09.bean.Ejb2Local.metodoInterno() of bean: Ejb2Impl is not allowed
 * CASO 3:
 * 		- sin credenciales
 * 		- no autetica y no ejecuta el servlet 
 */
@WebServlet(name="/TestServlet", urlPatterns={"/test"})
@ServletSecurity(@HttpConstraint(rolesAllowed = { "rolBueno", "rolMalo" }))
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	public Ejb1Local ejb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
        Principal principal = null;
        String authType = null;
        String remoteUser = null;

        // Get security principal
        principal = request.getUserPrincipal();
        // Get user name from login principal
        remoteUser = request.getRemoteUser();
        // Get authentication type
        authType = request.getAuthType();

        ejb.metodoExterno();
        
        writer.println("<html><head><title>EJBs - Tarea10</title></head><body>");
        writer.println("<h3>" + "Autenticacion OK " + "</h3>");
        writer.println("<p>" + "Principal  : " + principal.getName() + "</p>");
        writer.println("<p>" + "Remote User : " + remoteUser + "</p>");
        writer.println("<p>" + "Authentication Type : " + authType + "</p>");
        writer.println("<p>" + "MetodoExterno OK</p>");
        writer.println("</body></html>");
        writer.close();
	}

}
