package edu.masterjava.jsp.tarea08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.masterjava.jsp.comun.Utils;
import edu.masterjava.jsp.tarea08.dao.UsuariosDAO;
import edu.masterjava.jsp.tarea08.dao.impl.UsuariosDAOImpl;
import edu.masterjava.jsp.tarea08.model.Usuario;

/**
 * Tarea 08. Login + Home con etiqueta de usuario.
 * 
 * Servlet implementation class LoginServlet
 * 
 * Url pruebas:
 * 
 * http://localhost:8080/CU012_JSPs/index_tarea08.jsp
 * 
 * @author carloshernandezarques
 * 
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DOLOGIN_ACTION = "dologin";
	
	private static final String ERROR_CAMPOS_REQUERIDOS = "- Complete usuario y password";
	private static final String ERROR_USUARIO_NO_EXISTE = "- El usuario no existe.";
	private static final String ERROR_PASSWORD_ERRONEA = "- La password es erronea.";
	
	private static UsuariosDAO loginDAO; 
	
	/**
	 * @see HttpServlet#init()
	 */
	public void init() {
		loginDAO = new UsuariosDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
  	  	
		try {
	  	  	// realiza accion de login 
	  	  	if(DOLOGIN_ACTION.equals(action)) {
		  	  	doLogin(request, response);
	  	  	}
	  	  	else {
	  	  		// muestra pantalla de login
	  	  		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea08/login.jsp");
				dispatcher.forward(request, response);	
	  	  	}
		} catch (Exception e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea08/error.jsp");
			dispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Implementa la accion de login
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(Utils.esNuloVacio(username) || Utils.esNuloVacio(password)) {
			request.setAttribute("error", ERROR_CAMPOS_REQUERIDOS);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea08/login.jsp");	
			dispatcher.forward(request, response);	
		}
		else {
			Usuario usuario = loginDAO.obtenerUsuario(username);
			
			// usuario no existe
			if(usuario == null) {
				request.setAttribute("error", ERROR_USUARIO_NO_EXISTE);				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea08/login.jsp");
				dispatcher.forward(request, response);	
			}
			else {
				// login correcto
				String passwordMd5 = Utils.encriptarPassword(password);
				if(passwordMd5.equals(usuario.getPasswordMd5())) {
					// guarda usuario en session
					HttpSession session = request.getSession(true);
					session.setAttribute("usuario", usuario);

					// redirige a la home
					response.sendRedirect("home");
				}
				else {
					// password erronea
					request.setAttribute("error", ERROR_PASSWORD_ERRONEA);				
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tarea08/login.jsp");
					dispatcher.forward(request, response);	
				}
			}
		}
	}
	
}
