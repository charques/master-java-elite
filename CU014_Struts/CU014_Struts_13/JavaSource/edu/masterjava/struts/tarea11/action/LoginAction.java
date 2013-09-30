package edu.masterjava.struts.tarea11.action;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import edu.masterjava.struts.tarea11.bo.UsuariosBO;
import edu.masterjava.struts.tarea11.form.LoginForm;

public class LoginAction extends DispatchAction {

	private final static String PRODUCTS = "products";
	private final static String LOGIN = "login";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServletContext ctx = this.getServlet().getServletContext();
		String cadenaConexion = ctx.getInitParameter("cadenaConexion");
		String usuario = ctx.getInitParameter("userBBDD");
		String password = ctx.getInitParameter("passwordBBDD");

		UsuariosBO usuariosBO = new UsuariosBO(cadenaConexion, usuario,
				password);
		LoginForm rForm = (LoginForm) form;

		// Invoca a la operacion de login
		ActionMessages erroresDatosUsuario = null;
		try {
			erroresDatosUsuario = usuariosBO.login(rForm);
		} catch (SQLException e) {
			throw e;
		}

		// Chequea si hay errores
		if (erroresDatosUsuario.isEmpty()) {
			return mapping.findForward(PRODUCTS);
		} else {
			saveErrors(request, erroresDatosUsuario);
			return mapping.findForward(LOGIN);
		}
	}

}