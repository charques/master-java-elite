package edu.masterjava.jsp.tarea08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.masterjava.jsp.tarea08.model.Usuario;

/**
 * Tarea 08. Login + Home con etiqueta de usuario.
 * 
 * Servlet implementation class HomeServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU012_JSPs/index_tarea08.jsp
 * 
 * @author carloshernandezarques
 * 
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String KILLSESSION_ACTION = "killsession";
	
	/**
	 * @see HttpServlet#init()
	 */
	public void init() {
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recupera el usuario de sesion
		HttpSession session = request.getSession();
  	  	Usuario usuario = (Usuario) session.getAttribute("usuario");
  	  	
  	  	// procesa parametros
  	  	String action = request.getParameter("action");
  	  	if(KILLSESSION_ACTION.equals(action)) {
  			session.removeAttribute("usuario");
  			usuario = null;
  		}
  	  	
  	  	// si el usuario existe en session, accede a la home
  	  	if(usuario != null) {
  	  		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea08/home.jsp");
  	  		dispatcher.forward(request, response);	
  	  	}
  	  	else {
  	  		// el usuario no est‡ logado, redirige al login
  	  		response.sendRedirect("login");
  	  	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
