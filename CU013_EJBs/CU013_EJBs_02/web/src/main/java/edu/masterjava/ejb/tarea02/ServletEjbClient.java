package edu.masterjava.ejb.tarea02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.masterjava.ejb.tarea01.StringsBean;
import edu.masterjava.ejb.tarea01.StringsBeanLocal;
import edu.masterjava.ejb.tarea01.StringsBeanRemote;

/**
 * Servlet implementation class ServletEjbClient
 * 
 * URL prueba:
 * http://localhost:8080/cu013-tarea02-web/ServletEjbClient
 * 
 */
@WebServlet("/ServletEjbClient")
public class ServletEjbClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    StringsBeanLocal beanLocal;
	
	@EJB
    StringsBeanRemote beanRemote;
	
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("EJBs Tarea02");
		
		long temp1;
		long temp2;
		String texto = "";
		
		// Local
		temp1 = System.currentTimeMillis();
		for(int i = 0; i< 1000; i++) {
			texto = beanLocal.convertirMayusculas("Prueba local");
		}
		temp2 = System.currentTimeMillis() - temp1;
		System.out.println("local : " + temp2 + " ms");
		out.println("<br>" + "local : " + temp2 + " ms");
		
		// Remote
		temp1 = System.currentTimeMillis();
		for(int i = 0; i< 1000; i++) {
			texto = beanRemote.convertirMayusculas("Prueba remote 1");
		}
		temp2 = System.currentTimeMillis() - temp1;
		System.out.println("remote1 : " + temp2 + " ms");
		out.println("<br>" + "remote1 : " + temp2 + " ms");
		
		StringsBeanRemote ejb = null;
		try {
			ejb = lookupRemoteEJB();
		} catch (NamingException e) {
		}
		
		// Remote
		temp1 = System.currentTimeMillis();
		for(int i = 0; i< 1000; i++) {
			texto = ejb.convertirMayusculas("Prueba remote 2");
		}
		temp2 = System.currentTimeMillis() - temp1;
		System.out.println("remote2 : " + temp2 + " ms");
		out.println("<br>" + "remote2 : " + temp2 + " ms");
		
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
	
	private static StringsBeanRemote lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        final Context context = new InitialContext(jndiProperties);

        final String appName = "cu013-tarea01-ear";
        final String moduleName = "cu013-tarea01-ejb";
        final String distinctName = "";
        final String beanName = StringsBean.class.getSimpleName();

        final String viewClassName = StringsBeanRemote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);

        return (StringsBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }

}
