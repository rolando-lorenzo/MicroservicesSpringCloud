package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class DTO to GetFinalReports request
 * 
 * @author Rolando Lorenzo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFinalReportsRequest implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4528746251774437575L;

	/**
	 * Email del receptor
	 */
	@JsonProperty("ReceptorEmail")
	private String receptorEmail;

	/**
	 * Id del sector por el que se desea filtrar
	 */
	@JsonProperty("Sector")
	private String sector;

	/**
	 * Id de la compañía por la que filtrar
	 */
	@JsonProperty("Company")
	private int company;

	/**
	 * Id del tipo de clasificación por el que queremos buscar.
	 */
	@JsonProperty("ReportClasification")
	private int reportClasification;

	/**
	 * Id del tipo de clasificación por el que queremos buscar.
	 */
	@JsonProperty("ReportType")
	private int reportType;

	/**
	 * Indica si deben aplicarse filtros de alerta en la busqueda.
	 */
	@JsonProperty("customAlertsFilter")
	private String customAlertsFilter;

	/**
	 * Fecha desde la que buscar.
	 */
	@JsonProperty("From")
	private String from;

	/**
	 * Fecha hasta la que buscar.
	 */
	@JsonProperty("To")
	private String to;

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
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @return the company
	 */
	public int getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(int company) {
		this.company = company;
	}

	/**
	 * @return the reportClasification
	 */
	public int getReportClasification() {
		return reportClasification;
	}

	/**
	 * @param reportClasification
	 *            the reportClasification to set
	 */
	public void setReportClasification(int reportClasification) {
		this.reportClasification = reportClasification;
	}

	/**
	 * @return the reportType
	 */
	public int getReportType() {
		return reportType;
	}

	/**
	 * @param reportType
	 *            the reportType to set
	 */
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	/**
	 * @return the customAlertsFilter
	 */
	public String getCustomAlertsFilter() {
		return customAlertsFilter;
	}

	/**
	 * @param customAlertsFilter
	 *            the customAlertsFilter to set
	 */
	public void setCustomAlertsFilter(String customAlertsFilter) {
		this.customAlertsFilter = customAlertsFilter;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
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
