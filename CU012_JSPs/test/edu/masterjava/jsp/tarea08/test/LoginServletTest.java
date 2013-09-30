package edu.masterjava.jsp.tarea08.test;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;
import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;
import org.xml.sax.SAXException;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

import edu.masterjava.jsp.tarea08.LoginServlet;
import edu.masterjava.jsp.tarea08.test.util.ServletTesterUtils;

/**
 * @author carloshernandezarques
 * 
 */
public class LoginServletTest extends TestCase {

	/*@Test
	public void test() {
		ServletTester servletTester = ServletTesterUtils.createServletTester();
		HttpTester response = null;
		try {
			ServletTesterUtils.initServlet(servletTester, "/",
					LoginServlet.class, "/login");
			ServletTesterUtils.initServlet(servletTester, "/",
					LoginServlet.class, "*.jsp");

			response = ServletTesterUtils.makeRequest(servletTester, "/login");

		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals(200, response.getStatus());
		//assertEquals("", response.getContent());
	}*/
	
	@Test
	public void test() throws IOException, SAXException {
		File webXml = new File("./WebContent/WEB-INF/web.xml");
		ServletRunner sr = new ServletRunner(webXml);
		
	    sr.registerServlet( "login", LoginServlet.class.getName() );
	    
	    ServletUnitClient sc = sr.newClient();
	    WebRequest request   = new PostMethodWebRequest( "http://localhost:8080/CU012_JSPs/login" );
	    request.setParameter( "color", "red" );
	    WebResponse response = sc.getResponse( request );
	    assertNotNull( "No response received", response );
	    assertEquals( "content type", "text/plain", response.getContentType() );
	    assertEquals( "requested resource", "You selected red", response.getText() );
	}

}
