package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Tipo Identificacion
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoIdentificacion implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 897428676709316164L;

	/**
	 * id
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * descripcion
	 */
	@JsonProperty("Descripcion")
	private String descripcion;

	/**
	 * receptors
	 */
	@JsonProperty("Receptors")
	private String receptors;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
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

	/**
	 * @return the receptors
	 */
	public String getReceptors() {
		return receptors;
	}

	/**
	 * @param receptors
	 *            the receptors to set
	 */
	public void setReceptors(String receptors) {
		this.receptors = receptors;
	}

}
