package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFinalReportsResponse implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8925328885327739434L;
	
	/**
	 * Constructor dafault
	 */
	public GetFinalReportsResponse() {
	}
	
	/**
	 * Constructor with params
	 * 
	 * @param reportId
	 * @param title
	 * @param companies
	 * @param publishDate
	 * @param guid
	 * @param version
	 */
	public GetFinalReportsResponse(int reportId, String title, String companies, String publishDate, String guid,
			int version) {
		super();
		this.reportId = reportId;
		this.title = title;
		this.companies = companies;
		this.publishDate = publishDate;
		this.guid = guid;
		this.version = version;
	}



	/**
	 * Id del informe,
	 */
	@JsonProperty("ReportId")
	private int reportId;

	/**
	 * Titulo del informe
	 */
	@JsonProperty("Title")
	private String title;

	/**
	 * Nombres de las compañias del informe separadas por puntos y coma
	 */
	@JsonProperty("Companies")
	private String companies;

	/**
	 * Fecha de publicación
	 */
	@JsonProperty("PublishDate")
	private String publishDate;

	/**
	 * identificación del informe en el GD
	 */
	@JsonProperty("Guid")
	private String guid;

	/**
	 * Última versión del informe en TRINEO
	 */
	@JsonProperty("Version")
	private int version;

	/**
	 * @return the reportId
	 */
	public int getReportId() {
		return reportId;
	}

	/**
	 * @param reportId
	 *            the reportId to set
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the companies
	 */
	public String getCompanies() {
		return companies;
	}

	/**
	 * @param companies
	 *            the companies to set
	 */
	public void setCompanies(String companies) {
		this.companies = companies;
	}

	/**
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate
	 *            the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
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
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

}
