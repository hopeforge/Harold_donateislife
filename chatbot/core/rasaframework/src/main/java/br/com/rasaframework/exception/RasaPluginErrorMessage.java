package br.com.rasaframework.exception;

import java.io.Serializable;

/**
 * Message which contains a {@link RasaPluginError}.
 * 
 * @author Alvin P. Reyes
 */
public class RasaPluginErrorMessage implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The error from Facebook.
	 */
	private RasaPluginError error;

	/**
	 * Gets the {@link #error}.
	 *
	 * @return the {@link #error}.
	 */
	public RasaPluginError getError() {
		return error;
	}

	/**
	 * Sets the {@link #error}.
	 *
	 * @param error
	 *            the {@link #error} to set.
	 */
	public void setError(RasaPluginError error) {
		this.error = error;
	}

}
