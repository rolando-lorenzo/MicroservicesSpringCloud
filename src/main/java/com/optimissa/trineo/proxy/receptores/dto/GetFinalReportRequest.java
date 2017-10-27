package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFinalReportRequest implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4986522916485369812L;

	/**
	 * Email del receptor
	 */
	@JsonProperty("receptorEmail")
	private String receptorEmail;

	/**
	 * Identificación del documento a consumir
	 */
	@JsonProperty("Guid")
	private String guid;

	/**
	 * @return the receptorEmail
	 */
	public String getReceptorEmail() {
		return receptorEmail;
	}

	/**
	 * @param receptorEmail
	 *            the receptorEmail to set
	 */
	public void setReceptorEmail(String receptorEmail) {
		this.receptorEmail = receptorEmail;
	}

	/**
	 * @return the guid
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * @param guid
	 *            the guid to set
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * To string method of object
	 */
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
