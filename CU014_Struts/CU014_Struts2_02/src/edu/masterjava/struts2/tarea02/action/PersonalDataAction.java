package edu.masterjava.struts2.tarea02.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class PersonalDataAction extends ActionSupport {

	private String name;
	private String surname;
	private Date birthday;
	private String email;
	private String telephone;
	private Float salary;
	private Integer numChilds;

	public String addPersonalData() {
		return SUCCESS;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the salary
	 */
	public Float getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}

	/**
	 * @return the numChilds
	 */
	public Integer getNumChilds() {
		return numChilds;
	}

	/**
	 * @param numChilds
	 *            the numChilds to set
	 */
	public void setNumChilds(Integer numChilds) {
		this.numChilds = numChilds;
	}

}