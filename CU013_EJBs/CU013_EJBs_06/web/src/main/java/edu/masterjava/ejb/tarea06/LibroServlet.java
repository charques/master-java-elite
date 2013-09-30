package edu.masterjava.ejb.tarea06;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.ejb.tarea06.dao.LibroDaoRemote;
import edu.masterjava.ejb.tarea06.entity.Libro;

/**
 * Servlet implementation class LibroServlet
 * 
 * URL prueba:
 * http://localhost:8080/cu013-tarea06-web/libro
 * 
 */
@WebServlet(name="/LibroServlet", urlPatterns={"/libro"})
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    LibroDaoRemote libroDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Muestra todos los usuarios
        request.setAttribute("libros", libroDao.obtenerLibros());
        request.getRequestDispatcher("/libro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Crea un nuevo libro
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        if (titulo != null && autor != null)
            libroDao.crearLibro(new Libro(titulo, autor));
 
        // Muestra la lista
        doGet(request, response);
	}
	
}
