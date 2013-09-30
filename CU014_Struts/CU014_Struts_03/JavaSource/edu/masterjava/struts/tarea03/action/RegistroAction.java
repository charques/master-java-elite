/**
 * 
 */
package edu.masterjava.struts.tarea03.action;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.masterjava.struts.tarea03.bo.GestionUsuariosBO;
import edu.masterjava.struts.tarea03.form.RegistroForm;

/**
 * @author carloshernandezarques
 *
 */
public class RegistroAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ServletContext ctx = this.getServlet().getServletContext();
		String cadenaConexion = ctx.getInitParameter("cadenaConexion");
		String usuario = ctx.getInitParameter("userBBDD");
		String password = ctx.getInitParameter("passwordBBDD");
		
		GestionUsuariosBO gestUsuarios = new GestionUsuariosBO(cadenaConexion, usuario, password);
		RegistroForm rForm = (RegistroForm) form;
		try {
			gestUsuarios.registrar(rForm);
		}
		catch(SQLException e) {
			return mapping.findForward("error");
		}
		
		return mapping.findForward("exito");
	}
}
