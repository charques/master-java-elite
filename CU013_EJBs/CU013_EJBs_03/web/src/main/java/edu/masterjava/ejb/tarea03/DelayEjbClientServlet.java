package edu.masterjava.ejb.tarea03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

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
 * http://localhost:8080/cu013-tarea03-web/DelayEjbClientServlet
 * 
 */
@WebServlet("/DelayEjbClientServlet")
public class DelayEjbClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    StateTestBeanLocal beanLocal;
	
	Timer timer;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelayEjbClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		beanLocal.setValue(30);
		System.out.println("set valor: 30");
		
	    timer = new Timer();
	    timer.schedule(new GetValueFromEjbTask(beanLocal, response), 1000);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	class GetValueFromEjbTask extends TimerTask {
		
		StateTestBeanLocal bean;
		HttpServletResponse response;
		
		public GetValueFromEjbTask(StateTestBeanLocal pBean, HttpServletResponse pResponse) {
			bean = pBean;
			response = pResponse;
		}
		
	    public void run() {
	    	int valor = beanLocal.getValue();
			System.out.println("valor: " + valor);
			
			response.setContentType("text/html");
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<br>" + valor);
				out.println("</body>");
				out.println("</html>");
				out.close();
			} catch (IOException e) {
			}
	    }
	  }
	
}
