package edu.masterjava.struts.tarea15.form;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class SqlStatementForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	private String query;

	private Map<String, List<String>> results;

	private String sqlError;

	public SqlStatementForm() {
		super();
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the results
	 */
	public Map<String, List<String>> getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(Map<String, List<String>> results) {
		this.results = results;
	}

	/**
	 * @return the sqlError
	 */
	public String getSqlError() {
		return sqlError;
	}

	/**
	 * @param sqlError
	 *            the sqlError to set
	 */
	public void setSqlError(String sqlError) {
		this.sqlError = sqlError;
	}

	/**
	 * Validate
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);

		return errors;
	}

}
