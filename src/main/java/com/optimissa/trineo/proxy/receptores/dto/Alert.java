package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alert implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -3434914813724247626L;

	/**
	 * receptorId
	 */
	@JsonProperty("ReceptorId")
	private String receptorId;

	/**
	 * alerts
	 */
	@JsonProperty("Alerts")
	List<ReportTypeSubscribe> alerts;

	/**
	 * @return the receptorId
	 */
	public String getReceptorId() {
		return receptorId;
	}

	/**
	 * @param receptorId
	 *            the receptorId to set
	 */
	public void setReceptorId(String receptorId) {
		this.receptorId = receptorId;
	}

	/**
	 * @return the alerts
	 */
	public List<ReportTypeSubscribe> getAlerts() {
		return alerts;
	}

	/**
	 * @param alerts
	 *            the alerts to set
	 */
	public void setAlerts(List<ReportTypeSubscribe> alerts) {
		this.alerts = alerts;
	}

}
