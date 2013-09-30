package edu.masterjava.ejb.tarea05;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JMSClientServlet
 * 
 * URL prueba:
 * http://localhost:8080/cu013-tarea05-web/mensaje.jsp
 * 
 */
@WebServlet(name="/JMSClientServlet", urlPatterns={"/sendMessage"})
public class JMSClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String mensaje = request.getParameter("message");
        if (mensaje != null) {
        	
        	String destinationName = "queue/test";
    		Context ic = null;
    		ConnectionFactory cf = null;
    		Connection connection = null;

    		try {
    			ic = new InitialContext();

    			cf = (ConnectionFactory) ic.lookup("/ConnectionFactory");
    			Queue queue = (Queue) ic.lookup(destinationName);

    			connection = cf.createConnection();
    			Session session = connection.createSession(false,
    					Session.AUTO_ACKNOWLEDGE);
    			MessageProducer publisher = session.createProducer(queue);

    			connection.start();

    			TextMessage message = session.createTextMessage(mensaje);
    			publisher.send(message);

    		} catch (Exception exc) {
    			exc.printStackTrace();
    		} finally {

    			if (connection != null) {
    				try {
    					connection.close();
    				} catch (JMSException e) {
    					e.printStackTrace();
    				}
    			}
    		}
        }
		doGet(request, response);
	}

}