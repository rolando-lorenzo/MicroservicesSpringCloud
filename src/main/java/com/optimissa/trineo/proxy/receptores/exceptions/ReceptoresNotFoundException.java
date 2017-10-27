package com.optimissa.trineo.proxy.receptores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class exception if resource not found
 * 
 * @author Rolando Lorenzo
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReceptoresNotFoundException extends RuntimeException {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7625759070835543446L;

	/**
	 * Super constructor
	 */
	public ReceptoresNotFoundException(String message) {
		super(message);
	}
}
