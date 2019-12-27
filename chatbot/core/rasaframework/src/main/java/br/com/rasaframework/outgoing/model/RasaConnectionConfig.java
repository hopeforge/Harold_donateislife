package br.com.rasaframework.outgoing.model;

import java.io.Serializable;

/**
 * The Class RasaConnectionConfig.
 */
public class RasaConnectionConfig implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The protocol. */
	private String protocol;

	/** The host. */
	private String host;

	/** The port. */
	private Integer port;

	/** The token. */
	private String token;

	/**
	 * Gets the protocol.
	 *
	 * @return the protocol
	 */
	public String getProtocol() {
		if (this.protocol == null)
			this.protocol = "http";
		return protocol;
	}

	/**
	 * Sets the protocol.
	 *
	 * @param protocol
	 *            the new protocol
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 *
	 * @param host
	 *            the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port
	 *            the new port
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token
	 *            the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (port == null || protocol == null) {
			return this.host;
		} else {
			return this.protocol + "://" + this.host + ":" + this.port;
		}
	}

}
