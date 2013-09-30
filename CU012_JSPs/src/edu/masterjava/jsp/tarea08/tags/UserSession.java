package edu.masterjava.jsp.tarea08.tags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import edu.masterjava.jsp.tarea08.model.Usuario;

/**
 * Tag de session de usuario.
 * 
 * @author carloshernandezarques
 */
public class UserSession extends TagSupport {
	
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
	      try {
	    	  JspWriter out = pageContext.getOut();
	    	  
	    	  HttpSession session = pageContext.getSession();
	    	  Usuario usuario = (Usuario) session.getAttribute("usuario");
	    	  if(usuario != null) {
	    		  out.print("Bienvenido " + usuario.getNombre() + "!");
	    		  out.print("<br>");
	    		  out.print("<a href='/CU012_JSPs/home?action=killsession'>Cerrar sesi—n</a>");
	    	  }
	      } catch (IOException ioe) {
	    	 throw new JspException("IOException " + ioe.getMessage());
	      }
	      return SKIP_BODY;
	   }
	 
	   public int doEndTag() throws JspException {
	     return EVAL_PAGE;
	   }
}
