package br.com.rasaframework;

import br.com.rasaframework.outgoing.model.RasaConnectionConfig;

public class RasaContext {

	/** The rasa config. */
	private static RasaConnectionConfig rasaConfig;

	/** The instance. */
	private static RasaContext instance;

	/**
	 * Creates the action.
	 *
	 * @return the action frame builder
	 */
	public static RasaContext configure() {
		if (instance == null) {
			instance = new RasaContext();
		}
		rasaConfig = new RasaConnectionConfig();
		return instance;
	}

	/**
	 * Setup.
	 *
	 * @param serverProtocol
	 *            the server protocol
	 * @param serverUrl
	 *            the server url
	 * @param serverPort
	 *            the server port
	 */
	public void setup(String serverProtocol, String serverUrl, Integer serverPort) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setPort(serverPort);
		rasaConfig.setProtocol(serverProtocol);
	}

	/**
	 * Setup.
	 *
	 * @param serverProtocol
	 *            the server protocol
	 * @param serverUrl
	 *            the server url
	 * @param serverPort
	 *            the server port
	 * @param token
	 *            the token
	 */
	public void setup(String serverProtocol, String serverUrl, Integer serverPort, String token) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setPort(serverPort);
		rasaConfig.setProtocol(serverProtocol);
		rasaConfig.setToken(token);
	}

	/**
	 * Sets the up.
	 *
	 * @param serverUrl
	 *            the new up
	 */
	public void setup(String serverUrl) {
		rasaConfig.setHost(serverUrl);
	}

	/**
	 * Setup.
	 *
	 * @param serverUrl
	 *            the server url
	 * @param token
	 *            the token
	 */
	public void setup(String serverUrl, String token) {
		rasaConfig.setHost(serverUrl);
		rasaConfig.setToken(token);
	}

	/**
	 * Gets the rasa config.
	 *
	 * @return the rasa config
	 */
	public static RasaConnectionConfig getRasaConfig() {
		return rasaConfig;
	}
}
