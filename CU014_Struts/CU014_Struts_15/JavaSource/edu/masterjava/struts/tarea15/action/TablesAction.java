package edu.masterjava.struts.tarea15.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import edu.masterjava.struts.tarea15.bo.DataBaseBO;
import edu.masterjava.struts.tarea15.form.TablesForm;

public class TablesAction extends MappingDispatchAction {

	private final static String TABLES = "tables";

	public ActionForward tables(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		

		ServletContext ctx = this.getServlet().getServletContext();
		String cadenaConexion = ctx.getInitParameter("cadenaConexion");
		String usuario = ctx.getInitParameter("userBBDD");
		String password = ctx.getInitParameter("passwordBBDD");

		DataBaseBO dbBO = new DataBaseBO(cadenaConexion, usuario, password);
		TablesForm rForm = (TablesForm) form;

		// reset
		rForm.setNombreTabla(null);
		rForm.setDescTabla(null);
		
		// Obtiene las tablas
		List<String> tablas = null;
		try {
			tablas = dbBO.obtenerTablas();
		} catch (SQLException e) {
		}

		rForm.setTablas(tablas);
		return mapping.findForward(TABLES);
	}

	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServletContext ctx = this.getServlet().getServletContext();
		String cadenaConexion = ctx.getInitParameter("cadenaConexion");
		String usuario = ctx.getInitParameter("userBBDD");
		String password = ctx.getInitParameter("passwordBBDD");

		DataBaseBO dbBO = new DataBaseBO(cadenaConexion, usuario, password);
		TablesForm rForm = (TablesForm) form;

		String nombreTabla = request.getParameter("tableName");

		// Obtiene las tablas
		List<String> descTabla = null;
		try {
			descTabla = dbBO.obtenerDescTabla(nombreTabla);
		} catch (SQLException e) {
		}

		rForm.setNombreTabla(nombreTabla);
		rForm.setDescTabla(descTabla);
		return mapping.findForward(TABLES);
	}

}