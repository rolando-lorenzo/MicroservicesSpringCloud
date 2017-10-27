package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Receptor implements Serializable {
	
	/**
	 * Construct default
	 */
	public Receptor() {}
	
	/**
	 * Construct default
	 */
	public Receptor(String user, String password) {
		this.user = user;
		this.password = password;
	}

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -3450722774951826560L;

	/**
	 * id
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * user
	 */
	@JsonProperty("User")
	private String user;

	/**
	 * password
	 */
	@JsonProperty("Password")
	private String password;

	/**
	 * oldPassword
	 */
	@JsonProperty("OldPassword")
	private String oldPassword;

	/**
	 * newPassword
	 */
	@JsonProperty("newPassword")
	private String newPassword;

	/**
	 * idIdentificacion
	 */
	@JsonProperty("idIdentificacion")
	private String idIdentificacion;

	/**
	 * nif
	 */
	@JsonProperty("NIF")
	private String nif;

	/**
	 * residente
	 */
	@JsonProperty("Residente")
	private String residente;

	/**
	 * idNacionalidad
	 */
	@JsonProperty("idNacionalidad")
	private String idNacionalidad;

	/**
	 * nombre
	 */
	@JsonProperty("Nombre")
	private String nombre;

	/**
	 * apellido1
	 */
	@JsonProperty("Apellido1")
	private String apellido1;

	/**
	 * apellido2
	 */
	@JsonProperty("Apellido2")
	private String apellido2;

	/**
	 * email2
	 */
	@JsonProperty("Email2")
	private String email2;

	/**
	 * telefono
	 */
	@JsonProperty("Telefono")
	private String telefono;

	/**
	 * idIdioma
	 */
	@JsonProperty("idIdioma")
	private String idIdioma;

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
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword
	 *            the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the idIdentificacion
	 */
	public String getIdIdentificacion() {
		return idIdentificacion;
	}

	/**
	 * @param idIdentificacion
	 *            the idIdentificacion to set
	 */
	public void setIdIdentificacion(String idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif
	 *            the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @return the residente
	 */
	public String getResidente() {
		return residente;
	}

	/**
	 * @param residente
	 *            the residente to set
	 */
	public void setResidente(String residente) {
		this.residente = residente;
	}

	/**
	 * @return the idNacionalidad
	 */
	public String getIdNacionalidad() {
		return idNacionalidad;
	}

	/**
	 * @param idNacionalidad
	 *            the idNacionalidad to set
	 */
	public void setIdNacionalidad(String idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
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
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1
	 *            the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2
	 *            the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the email2
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2
	 *            the email2 to set
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the idIdioma
	 */
	public String getIdIdioma() {
		return idIdioma;
	}

	/**
	 * @param idIdioma
	 *            the idIdioma to set
	 */
	public void setIdIdioma(String idIdioma) {
		this.idIdioma = idIdioma;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" [");
		result.append(newLine);
		try {
			Field[] fields = this.getClass().getDeclaredFields();
	
			for (Field field : fields) {
				if (field.getName().equals("serialVersionUID")) {
					continue;
				}
				result.append("  ");
				
				result.append(field.getName());
				result.append(": ");
				result.append(field.get(this));
				
				result.append(newLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		result.append("]");

		return result.toString();
	}

}
