package br.com.rasaframework.outgoing.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Query.
 */
public class DataQuery implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The query. */
	@SerializedName("q")
	private String query;
	
	@SerializedName("project")
	private String project;

	/**
	 * Gets the query.
	 *
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * Sets the query.
	 *
	 * @param query
	 *            the new query
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * Gets the project
	 * 
	 * @return
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Sets the project
	 * 
	 * @param project
	 */
	public void setProject(String project) {
		this.project = project;
	}

	
}
