package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportTypeSubscribe implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -2474797238296377686L;

	/**
	 * id
	 */
	@JsonProperty("IdTipoInforme")
	private String idTipoInforme;

	/**
	 * email
	 */
	@JsonProperty("Email")
	private String email;

	/**
	 * fileEmail
	 */
	@JsonProperty("FileEmail")
	private String fileEmail;

	/**
	 * nombre
	 */
	@JsonProperty("Nombre")
	private String nombre;

	/**
	 * @return the idTipoInforme
	 */
	public String getIdTipoInforme() {
		return idTipoInforme;
	}

	/**
	 * @param idTipoInforme
	 *            the idTipoInforme to set
	 */
	public void setIdTipoInforme(String idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fileEmail
	 */
	public String getFileEmail() {
		return fileEmail;
	}

	/**
	 * @param fileEmail
	 *            the fileEmail to set
	 */
	public void setFileEmail(String fileEmail) {
		this.fileEmail = fileEmail;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
