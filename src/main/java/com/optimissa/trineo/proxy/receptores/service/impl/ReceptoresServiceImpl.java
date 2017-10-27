package com.optimissa.trineo.proxy.receptores.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.optimissa.trineo.proxy.receptores.dto.Alert;
import com.optimissa.trineo.proxy.receptores.dto.ClasificaInforme;
import com.optimissa.trineo.proxy.receptores.dto.ConfirmResponse;
import com.optimissa.trineo.proxy.receptores.dto.Idioma;
import com.optimissa.trineo.proxy.receptores.dto.Nacionalidad;
import com.optimissa.trineo.proxy.receptores.dto.Receptor;
import com.optimissa.trineo.proxy.receptores.dto.ReportTypeSubscribe;
import com.optimissa.trineo.proxy.receptores.dto.Sector;
import com.optimissa.trineo.proxy.receptores.dto.TipoIdentificacion;
import com.optimissa.trineo.proxy.receptores.dto.ValidarReceptorResponse;
import com.optimissa.trineo.proxy.receptores.service.ReceptoresService;
import com.optimissa.trineo.proxy.receptores.utils.ReceptoresUri;


/**
 * Consumes backend client from .NET platform
 * 
 * @author Rolando Lorenzo Lopez
 */
@Service("receptoresService")
public class ReceptoresServiceImpl implements ReceptoresService {
	
	protected Logger logger = Logger.getLogger(ReceptoresServiceImpl.class
			.getName());
	
	/**
	 * Rest template from backend .NET
	 */
	@Autowired
	private RestTemplate restTemplateClientDotNet;
	
	/**
	 * URIs of endpoint Backend .NET
	 */
	@Autowired
	private ReceptoresUri receptoresUri;
	
	/**
	 * Constant message not allow nulls
	 */
	private final String NOT_ALLOW_NULL= "No se permiten valores nulos. !";

	
	/**
	 * urlBase
	 */
	@Value( "${receptores.service.url.base}" )
	private String urlBase;
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidarReceptorResponse validateReceptor(Receptor receptor) {
		logger.info("Invocando backend .NET validateReceptor...");
		ValidarReceptorResponse result;
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		String url = urlBase + receptoresUri.getUrlValidarreceptor();
		logger.info("From uri: "+url);
		Map<String, String> params = new HashMap<String, String>();
	    params.put("user", receptor.getUser());
	    params.put("password", receptor.getPassword());
	    
	    result = restTemplateClientDotNet.getForObject(url, ValidarReceptorResponse.class, params);
	    logger.info("Se obtiene obj: "+result);
	    return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse forgottenPassword(Receptor receptor) throws RestClientException {
		ConfirmResponse conRep = null;
		ResponseEntity<String> response = null;
		logger.info("Invocando backend .NET forgottenPassword...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlForgottenPassword();
		logger.info("From uri: "+url);
		
		Map<String, String> params1 = new HashMap<String, String>();
	    params1.put("User", receptor.getUser());
	    params1.put("Password", receptor.getPassword());
		
		response = restTemplateClientDotNet.exchange(url, HttpMethod.POST, getRequestEntity(params1), String.class);
		
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
		logger.info("Invocando backend .NET changePassword...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlChangePassword();
		logger.info("From uri: "+url);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", receptor.getId());
		params.put("User", receptor.getUser());
		params.put("OldPassword", receptor.getOldPassword());
		params.put("newPassword", receptor.getNewPassword());
		
		
		
		response = restTemplateClientDotNet.exchange(url, HttpMethod.POST, getRequestEntity(params), String.class);
		
		
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
		logger.info("Invocando backend .NET updateReceptor...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlUpdateReceptor();
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
		
		
		response = restTemplateClientDotNet.exchange(url, HttpMethod.POST, getRequestEntity(params), String.class);
		
		
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
		ParameterizedTypeReference<List<TipoIdentificacion>> listIdentificaciones = new ParameterizedTypeReference<List<TipoIdentificacion>>() {};
		String url = urlBase + receptoresUri.getUrlGetIdentificacion();
		logger.info("From uri: "+url);
		ResponseEntity<List<TipoIdentificacion>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				listIdentificaciones);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Nacionalidad> getNacionalidad() {
		String url = urlBase + receptoresUri.getUrlNacionalidad();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Nacionalidad>> listNacionalidades = new ParameterizedTypeReference<List<Nacionalidad>>() {};
		ResponseEntity<List<Nacionalidad>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				listNacionalidades);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Idioma> getIdioma() {
		String url = urlBase + receptoresUri.getUrlGetIdioma();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Idioma>> listIdiomas = new ParameterizedTypeReference<List<Idioma>>() {};
		ResponseEntity<List<Idioma>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				listIdiomas);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ClasificaInforme> clasificaInforme() {
		String url = urlBase + receptoresUri.getUrlClasificaInforme();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<ClasificaInforme>> clasificaInforme = new ParameterizedTypeReference<List<ClasificaInforme>>() {};
		ResponseEntity<List<ClasificaInforme>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				clasificaInforme);
		return response.getBody();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Sector> getAllSectores() {
		String url = urlBase + receptoresUri.getUrlSectores();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Sector>> listSectores = new ParameterizedTypeReference<List<Sector>>() {
		};
		ResponseEntity<List<Sector>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null, listSectores);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ReportTypeSubscribe> getReportTypes(String receptorId) {
		
		String url = urlBase + receptoresUri.getUrlGetReportTypes();
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("receptorId", receptorId);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		logger.info("From uri: "+builder.buildAndExpand(uriParams).toUri());
		ParameterizedTypeReference<List<ReportTypeSubscribe>> listReports = new ParameterizedTypeReference<List<ReportTypeSubscribe>>() {
		};
		ResponseEntity<List<ReportTypeSubscribe>> response = restTemplateClientDotNet.exchange(
				builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, listReports);
		return response.getBody();
	}

	@Override
	public void setAlerts(Alert alerts) {
		// TODO Auto-generated method stub
		
	}
	
	

}
