package edu.masterjava.struts.tarea15.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.masterjava.struts.tarea15.bo.DataBaseBO;
import edu.masterjava.struts.tarea15.form.SqlStatementForm;

public class SqlStatementAction extends DispatchAction {

	private final static String SQL_STATEMENT = "sqlstatement";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServletContext ctx = this.getServlet().getServletContext();
		String cadenaConexion = ctx.getInitParameter("cadenaConexion");
		String usuario = ctx.getInitParameter("userBBDD");
		String password = ctx.getInitParameter("passwordBBDD");

		DataBaseBO dbBO = new DataBaseBO(cadenaConexion, usuario, password);
		SqlStatementForm rForm = (SqlStatementForm) form;

		// Invoca a la operacion
		Map<String, List<String>> results = null;
		try {
			results = dbBO.ejecutaQuery(rForm.getQuery());
		} 
		catch (SQLException e) {
			rForm.setSqlError(e.getMessage());
			return mapping.findForward(SQL_STATEMENT);
		}

		rForm.setResults(results);
		return mapping.findForward(SQL_STATEMENT);
	}

}