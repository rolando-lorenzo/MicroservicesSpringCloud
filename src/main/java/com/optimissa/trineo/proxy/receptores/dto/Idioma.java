package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Idioma
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Idioma implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 2982421598737628331L;

	/**
	 * id
	 */
	@JsonProperty("Id")
	private int id;

	/**
	 * descripcion
	 */
	@JsonProperty("Descripcion")
	private String descripcion;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}