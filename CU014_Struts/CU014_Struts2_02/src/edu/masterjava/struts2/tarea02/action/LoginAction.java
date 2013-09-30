package edu.masterjava.struts2.tarea02.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {

		if (this.username.equals("admin") && this.password.equals("exes")) {
			return SUCCESS;
		} else {
			addActionError(getText("error.login"));
			return ERROR;
		}
		//return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
