package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase de dominio el cual mappea objeto de ClasificaInforme del Backend
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClasificaInforme implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -7601797499563637279L;

	/**
	 * id
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * tipo
	 */
	@JsonProperty("Tipo")
	private String tipo;

	/**
	 * tiposInforme
	 */
	@JsonProperty("TiposInforme")
	private String tiposInforme;

	/**
	 * code
	 */
	@JsonProperty("code")
	private String code;

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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tiposInforme
	 */
	public String getTiposInforme() {
		return tiposInforme;
	}

	/**
	 * @param tiposInforme
	 *            the tiposInforme to set
	 */
	public void setTiposInforme(String tiposInforme) {
		this.tiposInforme = tiposInforme;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
