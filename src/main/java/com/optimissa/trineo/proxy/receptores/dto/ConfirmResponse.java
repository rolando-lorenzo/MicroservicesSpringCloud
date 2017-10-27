package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Confirm Response
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmResponse implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 3937937304652737477L;
	
	/**
	 * Confirm
	 */
	private boolean confirm;

	/**
	 * @return the confirm
	 */
	public boolean isConfirm() {
		return confirm;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

}
