package edu.masterjava.struts.tarea11.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


public class LoginForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	public LoginForm() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Validate
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)  
    {  
		ActionErrors errors = super.validate(mapping, request); 
       
        return errors;  
    }  
	
	
}
