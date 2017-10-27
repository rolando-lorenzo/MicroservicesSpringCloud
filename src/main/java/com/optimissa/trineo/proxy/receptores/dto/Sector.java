package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase de dominio el cual mappea objeto de Sector del Backend
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sector implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -2244062288469771532L;

	/**
	 * id
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * nombre
	 */
	@JsonProperty("Nombre")
	private String nombre;

	/**
	 * campanias
	 */
	@JsonProperty("compañias")
	private String campanias;

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

	/**
	 * @return the campanias
	 */
	public String getCampanias() {
		return campanias;
	}

	/**
	 * @param campanias
	 *            the campanias to set
	 */
	public void setCampanias(String campanias) {
		this.campanias = campanias;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SectoresDTO [id=" + id + ", nombre=" + nombre + ", campanias=" + campanias + "]";
	}
	
	

}
