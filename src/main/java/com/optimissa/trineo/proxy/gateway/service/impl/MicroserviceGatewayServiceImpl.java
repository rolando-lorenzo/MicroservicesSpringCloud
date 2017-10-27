package com.optimissa.trineo.proxy.gateway.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.optimissa.trineo.proxy.gateway.service.MicroserviceGatewayService;
import com.optimissa.trineo.proxy.receptores.dto.Alert;
import com.optimissa.trineo.proxy.receptores.dto.ClasificaInforme;
import com.optimissa.trineo.proxy.receptores.dto.ConfirmResponse;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportRequest;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportResponse;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportsRequest;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportsResponse;
import com.optimissa.trineo.proxy.receptores.dto.Idioma;
import com.optimissa.trineo.proxy.receptores.dto.Nacionalidad;
import com.optimissa.trineo.proxy.receptores.dto.Receptor;
import com.optimissa.trineo.proxy.receptores.dto.ReportTypeSubscribe;
import com.optimissa.trineo.proxy.receptores.dto.Sector;
import com.optimissa.trineo.proxy.receptores.dto.TipoIdentificacion;
import com.optimissa.trineo.proxy.receptores.dto.ValidarReceptorResponse;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Rolando Lorenzo Lopez
 */
@Service("microserviceGatewayService")
public class MicroserviceGatewayServiceImpl implements MicroserviceGatewayService {

	/**
	 * Rest template from Microservice
	 */
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
	/**
	 * Constant message not allow nulls
	 */
	private final String NOT_ALLOW_NULL= "No se permiten valores nulos. !";
	
	/**
	 * Microservice URL 
	 */
	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(MicroserviceGatewayServiceImpl.class
			.getName());
	
	public MicroserviceGatewayServiceImpl(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Sector> getAllSectores() {
		ParameterizedTypeReference<List<Sector>> listSectores = new ParameterizedTypeReference<List<Sector>>() {};  
		logger.info("[MicroserviceGatewayService] Searching url service: "+ serviceUrl+"/sectores");
		ResponseEntity<List<Sector>> response = restTemplate.exchange(serviceUrl+"/sectores",HttpMethod.GET,null, listSectores);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidarReceptorResponse validateReceptor(Receptor receptor) {
		logger.info("Invocando Microservice validateReceptor...");
		ValidarReceptorResponse result;
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		String url = serviceUrl + "/validateReceptor";
		logger.info("From uri: "+url);
		Map<String, String> params = new HashMap<String, String>();
	    params.put("user", receptor.getUser());
	    params.put("password", receptor.getPassword());
	    
	    result = restTemplate.getForObject(url, ValidarReceptorResponse.class, params);
	    logger.info("Se obtiene obj: "+result);
	    return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse forgottenPassword(Receptor receptor) {
		ConfirmResponse conRep = null;
		ResponseEntity<String> response = null;
		logger.info("Invocando Microservice forgottenPassword...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = serviceUrl + "/forgottenPassword";
		logger.info("From uri: "+url);
		
		Map<String, String> params1 = new HashMap<String, String>();
	    params1.put("User", receptor.getUser());
	    params1.put("Password", receptor.getPassword());
		
		response = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(params1), String.class);
		
		logger.info("Se obtiene obj: "+response);
		conRep = new ConfirmResponse();
		if(response != null) {
			conRep.setConfirm(Boolean.valueOf(response.getBody()));
		} 
	    return conRep;
	}
	
	/**
	 * Get request entity
	 * @param params
	 * @return
	 */
	private HttpEntity<Map<String, String>> getRequestEntity(Map<String, String> params){
		logger.info("Params: "+params);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Map<String, String>>(params, headers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse changePassword(Receptor receptor) {
		ConfirmResponse conRep = null;
		ResponseEntity<String> response = null;
		logger.info("Invocando Microservice changePassword...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = serviceUrl + "/changePassword";
		logger.info("From uri: "+url);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", receptor.getId());
		params.put("User", receptor.getUser());
		params.put("OldPassword", receptor.getOldPassword());
		params.put("newPassword", receptor.getNewPassword());
		
		
		try {
			response = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(params), String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("Se obtiene obj: "+response);
		conRep = new ConfirmResponse();
		if(response != null) {
			logger.info("Confirm: "+response.getBody());
			conRep.setConfirm(Boolean.valueOf(response.getBody()));
		} 
	    return conRep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse updateReceptor(Receptor receptor) {
		ConfirmResponse conRep;
		ResponseEntity<String> response = null;
		logger.info("Invocando Microservice updateReceptor...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = serviceUrl + "/updateReceptor";
		logger.info("From uri: "+url);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Id", receptor.getId());
		params.put("idIdentificacion", receptor.getIdIdentificacion());
		params.put("NIF", receptor.getNif());
		params.put("Residente", receptor.getResidente());
		params.put("idNacionalidad", receptor.getIdNacionalidad());
		params.put("Nombre", receptor.getNombre());
		params.put("Apellido1", receptor.getApellido1());
		params.put("Apellido2", receptor.getApellido2());
		params.put("Email2", receptor.getEmail2());
		params.put("Telefono", receptor.getTelefono());
		params.put("idIdioma", receptor.getIdIdioma());
		
		try {
			response = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(params), String.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("Se obtiene obj: "+response);
		conRep = new ConfirmResponse();
		if(response != null) {
			logger.info("Confirm: "+response.getBody());
			conRep.setConfirm(Boolean.valueOf(response.getBody()));
		} 
		return conRep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TipoIdentificacion> getIdentificacion() {
		logger.info("Invocando Microservice getIdentificacion...");
		ParameterizedTypeReference<List<TipoIdentificacion>> listIdentificaciones = new ParameterizedTypeReference<List<TipoIdentificacion>>() {};
		String url = serviceUrl + "/getIdentificacion";
		logger.info("From uri: "+url);
		ResponseEntity<List<TipoIdentificacion>> response = restTemplate.exchange(
				url, HttpMethod.GET, null,
				listIdentificaciones);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Nacionalidad> getNacionalidad() {
		logger.info("Invocando Microservice getNacionalidad...");
		String url = serviceUrl + "/getNacionalidad";
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Nacionalidad>> listNacionalidades = new ParameterizedTypeReference<List<Nacionalidad>>() {};
		ResponseEntity<List<Nacionalidad>> response = restTemplate.exchange(
				url, HttpMethod.GET, null,
				listNacionalidades);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Idioma> getIdioma() {
		logger.info("Invocando Microservice getIdioma...");
		String url = serviceUrl + "/getIdioma";
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Idioma>> listIdiomas = new ParameterizedTypeReference<List<Idioma>>() {};
		ResponseEntity<List<Idioma>> response = restTemplate.exchange(
				url, HttpMethod.GET, null,
				listIdiomas);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ClasificaInforme> clasificaInforme() {
		logger.info("Invocando Microservice clasificaInforme...");
		String url = serviceUrl + "/clasificaInforme";
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<ClasificaInforme>> clasificaInforme = new ParameterizedTypeReference<List<ClasificaInforme>>() {};
		ResponseEntity<List<ClasificaInforme>> response = restTemplate.exchange(
				url, HttpMethod.GET, null,
				clasificaInforme);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ReportTypeSubscribe> getReportTypes(String receptorId) {
		logger.info("Invocando Microservice getReportTypes...");
		String url = serviceUrl + "/getReportTypes/{receptorId}";
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("receptorId", receptorId);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		logger.info("From uri: "+builder.buildAndExpand(uriParams).toUri());
		ParameterizedTypeReference<List<ReportTypeSubscribe>> listReports = new ParameterizedTypeReference<List<ReportTypeSubscribe>>() {
		};
		ResponseEntity<List<ReportTypeSubscribe>> response = restTemplate.exchange(
				builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, listReports);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlerts(Alert alerts) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetFinalReportsResponse getFinalReports(GetFinalReportsRequest finalReportsRequest) {

		ResponseEntity<GetFinalReportsResponse> responseEntity = null;
		logger.info("Invocando Microservice getFinalReports...");
		if(finalReportsRequest ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = serviceUrl + "/getFinalReports";
		logger.info("From uri: "+url);
		HttpEntity<GetFinalReportsRequest> request = new HttpEntity<>(finalReportsRequest);
		
	    responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, GetFinalReportsResponse.class);
		
		logger.info("Se obtiene obj: "+responseEntity);
		
		return responseEntity.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetFinalReportResponse getFinalReport(GetFinalReportRequest finalReportRequest) {
		ResponseEntity<GetFinalReportResponse> responseEntity = null;
		logger.info("Invocando Microservice getFinalReports...");
		if(finalReportRequest ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = serviceUrl + "/getFinalReport";
		logger.info("From uri: "+url);
		HttpEntity<GetFinalReportRequest> request = new HttpEntity<>(finalReportRequest);
		
	    responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, GetFinalReportResponse.class);
		
		logger.info("Se obtiene obj: "+responseEntity);
		
		return responseEntity.getBody();
	}

}
