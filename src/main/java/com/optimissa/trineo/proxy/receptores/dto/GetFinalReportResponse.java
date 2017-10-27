package com.optimissa.trineo.proxy.receptores.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFinalReportResponse {
	
	/**
	 * Constructor default
	 */
	public GetFinalReportResponse() {}

	/**
	 * Constructor with params
	 * @param data
	 * @param dataError
	 */
	public GetFinalReportResponse(byte[] data, String dataError) {
		super();
		this.data = data;
		this.dataError = dataError;
	}

	/**
	 * Array de bytes con la informacion del fichero.
	 */
	@JsonProperty("Data")
	private byte[] data;

	/**
	 * En caso de haber algun error de negocio, este vendrá aquí indicado
	 */
	@JsonProperty("DataError")
	private String dataError;

	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * @return the dataError
	 */
	public String getDataError() {
		return dataError;
	}

	/**
	 * @param dataError
	 *            the dataError to set
	 */
	public void setDataError(String dataError) {
		this.dataError = dataError;
	}

}
