package edu.masterjava.ejb.tarea04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 * 
 * URL prueba: http://localhost:8080/cu013-tarea04-web/UsuarioServlet
 * 
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuarioDao usuarioDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");

		// Crea usuario
		String nombre = "usuario1";
		String password = "password1";
		Long id1 = usuarioDao.saveUsuario(new Usuario(nombre, password));
		out.println("<br> Usuario creado " + id1);

		nombre = "usuario2";
		password = "password2";
		Long id2 = usuarioDao.saveUsuario(new Usuario(nombre, password));
		out.println("<br> Usuario creado " + id2);

		// Recupera usuarios
		List<Usuario> usuarios = usuarioDao.getUsuarios();
		out.println("<br><br>Lista de usuarios: " + usuarios.size());
		if (usuarios != null) {
			for (Usuario usuario : usuarios) {
				out.println("<br>" + usuario.toString());
			}
		}
		out.println("<br>");

		// Actualiza usuario
		out.println("<br> Actualiza usuario " + id2);
		Usuario u2 = usuarioDao.obtenerUsuario(id2);
		u2.setNombre("XXXX");
		usuarioDao.updateUsuario(u2);

		// Recupera usuarios
		usuarios = usuarioDao.getUsuarios();
		out.println("<br><br>Lista de usuarios: " + usuarios.size());
		if (usuarios != null) {
			for (Usuario usuario : usuarios) {
				out.println("<br>" + usuario.toString());
			}
		}
		out.println("<br>");

		// Elimina usuario
		usuarioDao.eliminaUsuario(id1);
		out.println("<br> Elimina usuario " + id1);

		// Elimina usuario
		usuarioDao.eliminaUsuario(id2);
		out.println("<br> Elimina usuario " + id2);

		// Recupera usuarios
		usuarios = usuarioDao.getUsuarios();
		out.println("<br><br>Lista de usuarios: " + usuarios.size());
		if (usuarios != null) {
			for (Usuario usuario : usuarios) {
				out.println("<br>" + usuario.toString());
			}
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

		// Crea un nuevo usuario
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		if (nombre != null && password != null)
			usuarioDao.saveUsuario(new Usuario(nombre, password));

		// Muestra la lista
		doGet(request, response);
	}

}
