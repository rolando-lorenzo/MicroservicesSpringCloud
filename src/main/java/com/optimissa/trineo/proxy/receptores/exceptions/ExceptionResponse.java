package com.optimissa.trineo.proxy.receptores.exceptions;

import java.io.Serializable;

/**
 * Response class for all exceptions
 * 
 * @author Rolando Lorenzo
 *
 */
public class ExceptionResponse implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1005829938197238782L;

	/**
	 * code
	 */
	private String error;

	/**
	 * message
	 */
	private String message;

	/**
	 * details
	 */
	private String details;

	/**
	 * Constructor for all parameters
	 */
	public ExceptionResponse(String error, String message, String details) {
		super();
		this.error = error;
		this.message = message;
		this.details = details;
	}

	/**
	 * Default constructor
	 */
	public ExceptionResponse() {
	}

	/**
	 * @return the code
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setError(String code) {
		this.error = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
