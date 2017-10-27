package com.optimissa.trineo.proxy.gateway.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.trineo.proxy.gateway.service.MicroserviceGatewayService;
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
 * Client controller, fetches Receptores info from the microservice via
 * {@link MicroserviceGatewayService}.
 * 
 * @author Rolando Lorenzo Lopez
 */
@RestController
public class MicroserviceGatewayController {
	
	@Autowired
	private MicroserviceGatewayService microserviceGatewayService;
	
	protected Logger logger = Logger.getLogger(MicroserviceGatewayController.class
			.getName());
	
	public MicroserviceGatewayController(MicroserviceGatewayService microserviceGatewayService) {
		this.microserviceGatewayService = microserviceGatewayService;
	}
	
	
	/**
	 * validate Receptor from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/receptor/validateReceptor",
			method = RequestMethod.GET,
			produces = "application/json")
	public ValidarReceptorResponse validateReceptor(@RequestParam String user,
			@RequestParam String password) {

		logger.info("[MicroserviceGatewayController] - validateReceptor() invoked... ");
		return microserviceGatewayService.validateReceptor(new Receptor(user,password));

	}
	
	/**
	 * forgotten Password from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/receptor/forgottenPassword",
			method = RequestMethod.POST, 
			produces = "application/json")
	public ConfirmResponse forgottenPassword(@RequestBody Receptor receptor) {

		logger.info("[MicroserviceGatewayController] - forgottenPassword() invoked... "+receptor);
		if(receptor == null || receptor.getUser() == null || receptor.getPassword()== null) {
			throw new IllegalArgumentException("No se permiten valores nulos para User y Password");
		}
		
		return microserviceGatewayService.forgottenPassword(receptor);

	}
	
	/**
	 * ChangePassword  from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/receptor/changePassword",
			method = RequestMethod.POST, 
			produces = "application/json")
	public ConfirmResponse changePassword(@RequestBody Receptor receptor) {

		logger.info("[MicroserviceGatewayController] - changePassword() invoked... ");
		return microserviceGatewayService.changePassword(receptor);

	}
	
	
	/**
	 * Update Receptor from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/administracion/updateReceptor",
			method = RequestMethod.POST, 
			produces = "application/json")
	public ConfirmResponse UpdateReceptor(@RequestBody Receptor receptor) {
		logger.info("[MicroserviceGatewayController] - UpdateReceptor() invoked... ");
		return microserviceGatewayService.updateReceptor(receptor);
	}
	
	/**
	 * Get Identificacion from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/administracion/getIdentificacion",
			method = RequestMethod.GET, 
			produces = "application/json")
	public List<TipoIdentificacion> getIdentificacion() {
		logger.info("[MicroserviceGatewayController] - getIdentificacion() invoked... ");
		return microserviceGatewayService.getIdentificacion();
	}
	
	/**
	 * Get nacionalidad from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/analisis/nacionalidad",
			method = RequestMethod.GET, 
			produces = "application/json")
	public List<Nacionalidad> nacionalidad() {
		logger.info("[MicroserviceGatewayController] - nacionalidad() invoked... ");
		return microserviceGatewayService.getNacionalidad();
	}
	
	/**
	 * Get Idioma from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/administracion/getIdioma",
			method = RequestMethod.GET, 
			produces = "application/json")
	public List<Idioma> getIdioma() {
		logger.info("[MicroserviceGatewayController] - getIdioma() invoked... ");
		return microserviceGatewayService.getIdioma();
	}
	
	/**
	 * ClasificaInforme from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/administracion/clasificaInforme",
			method = RequestMethod.GET, 
			produces = "application/json")
	public List<ClasificaInforme> clasificaInforme() {
		logger.info("[MicroserviceGatewayController] - clasificaInforme() invoked... ");
		return microserviceGatewayService.clasificaInforme();
	}
	
	/**
	 * Get all Sectores from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/administracion/sectores", 
			method = RequestMethod.GET, 
			produces = "application/json")
	public List<Sector> getAllReceptores() {

		logger.info("[MicroserviceGatewayController] - getAllReceptores() invoked... ");
		return microserviceGatewayService.getAllSectores();

	}
	
	/**
	 * Get Report Types from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/receptor/getReportTypes/{receptorId}",
			produces = "application/json",method= RequestMethod.GET)
	public List<ReportTypeSubscribe> getReportTypes(@PathVariable String receptorId) {
		logger.info("[MicroserviceGatewayController] - getReportTypes() invoked... "+receptorId);
		return microserviceGatewayService.getReportTypes(receptorId);
	}
	
	/**
	 * Get Report Types from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/analisis/setAlerts",
			method = RequestMethod.POST, 
			produces = "application/json")
	public void setAlerts() {
		logger.info("[MicroserviceGatewayController] - setAlerts() invoked... ");

	}

	
	/**
	 * Get Final reports from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/informes/getFinalReports",
			method = RequestMethod.POST, 
			produces = "application/json")
	public GetFinalReportsResponse getFinalReports(@RequestBody GetFinalReportsRequest finalReportsRequest ) {
		logger.info("[MicroserviceGatewayController] - getFinalReports() invoked... ");
		return microserviceGatewayService.getFinalReports(finalReportsRequest);
	}
	
	
	/**
	 * Get Final report from Gateway service
	 * @return
	 */
	@RequestMapping(value= "/informes/getFinalReport",
			method = RequestMethod.POST, 
			produces = "application/json")
	public GetFinalReportResponse getFinalReport(@RequestBody GetFinalReportRequest finalReportRequest ) {
		logger.info("[MicroserviceGatewayController] - getFinalReport() invoked... ");
		return microserviceGatewayService.getFinalReport(finalReportRequest);
	}
}
