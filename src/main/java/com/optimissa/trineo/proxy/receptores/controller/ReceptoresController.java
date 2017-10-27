package com.optimissa.trineo.proxy.receptores.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.optimissa.trineo.proxy.receptores.service.ReceptoresService;

/**
 * A RESTFul controller for accessing Receptores information.
 * 
 * @author Rolando Lorenzo Lopez
 */
@RestController
public class ReceptoresController {
	
	/**
	 * Logger 
	 */
	protected Logger logger = Logger.getLogger(ReceptoresController.class
			.getName());
	
	/**
	 * Service receptores
	 */
	@Autowired
	private ReceptoresService receptoresService;
	
	/**
	 * Method to validate Receptor
	 * @return ValidarReceptorResponse 
	 */
	@RequestMapping(value= "/validateReceptor",
			produces = "application/json",
			method= RequestMethod.GET)
	ValidarReceptorResponse validateReceptor(@RequestParam String user,
			@RequestParam String password) {
		logger.info("[ReceptoresController] - validateReceptor() invoked... User"+user+" Pass:"+password);
		
		return receptoresService.validateReceptor(new Receptor(user,password));
	} 
	
	/**
	 * Method to forgotten Password
	 * @return ConfirmResponse 
	 */
	@RequestMapping(value= "/forgottenPassword",
			produces = "application/json",
			method= RequestMethod.POST)
	ConfirmResponse forgottenPassword(@RequestBody Receptor receptor) {
		logger.info("[ReceptoresController] - forgottenPassword() invoked... "+receptor);
		return receptoresService.forgottenPassword(receptor);
	} 
	
	
	/**
	 * Method to change Password
	 * @return ConfirmResponse 
	 */
	@RequestMapping(value= "/changePassword",
			produces = "application/json",
			method= RequestMethod.POST)
	ConfirmResponse changePassword(@RequestBody Receptor receptor) {
		logger.info("[ReceptoresController] - changePassword() invoked... "+receptor);
		return receptoresService.changePassword(receptor);
	}
	
	
	/**
	 * Method to update Receptor
	 * @return ConfirmResponse 
	 */
	@RequestMapping(value= "/updateReceptor",
			produces = "application/json",
			method= RequestMethod.POST)
	ConfirmResponse updateReceptor(@RequestBody Receptor receptor) {
		logger.info("[ReceptoresController] - updateReceptor() invoked... "+receptor);
		return receptoresService.updateReceptor(receptor);
	}
	
	/**
	 * Method to get identificaciones
	 * @return
	 */
	@RequestMapping(value= "/getIdentificacion",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<TipoIdentificacion> getIdentificacion() {

		logger.info("[ReceptoresController] - getIdentificacion() invoked... ");
		return receptoresService.getIdentificacion();

	}
	
	/**
	 * Method to get Nacionalidad
	 * @return
	 */
	@RequestMapping(value= "/getNacionalidad",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<Nacionalidad> getNacionalidad() {

		logger.info("[ReceptoresController] - getNacionalidad() invoked... ");
		return receptoresService.getNacionalidad();

	}
	
	/**
	 * Method to get Idioma
	 * @return
	 */
	@RequestMapping(value= "/getIdioma",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<Idioma> getIdioma() {

		logger.info("[ReceptoresController] - getIdioma() invoked... ");
		return receptoresService.getIdioma();

	}
	
	/**
	 * Method to get clasificaInforme
	 * @return
	 */
	@RequestMapping(value= "/clasificaInforme",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<ClasificaInforme> clasificaInforme() {

		logger.info("[ReceptoresController] - clasificaInforme() invoked... ");
		return receptoresService.clasificaInforme();
		
	}
	
	/**
	 * Method to get sectores
	 * @return
	 */
	@RequestMapping(value= "/sectores",produces = "application/json",method= RequestMethod.GET)
	public List<Sector> getAllReceptores() {
		logger.info("[ReceptoresController] - getAllReceptores() invoked... ");
		return receptoresService.getAllSectores();

	}
	
	/**
	 * Method to get Report Types
	 * @return
	 */
	@RequestMapping(value= "/getReportTypes/{receptorId}",produces = "application/json",method= RequestMethod.GET)
	public List<ReportTypeSubscribe> getReportTypes(@PathVariable String receptorId) {

		logger.info("[ReceptoresController] - getReportTypes() invoked... " + receptorId);
		return receptoresService.getReportTypes(receptorId);

	}
	
	/**
	 * Method to get final reports 
	 * 
	 * @param request
	 * @return GetFinalReportsResponse
	 */
	@RequestMapping(value= "/getFinalReports",
			produces = "application/json",
			method= RequestMethod.POST)
	public GetFinalReportsResponse getFinalReports(@RequestBody GetFinalReportsRequest request) {
		logger.info("[ReceptoresController] - getFinalReports() invoked... "+request);
		return new GetFinalReportsResponse(1, "title", "companies", "publishDate", "guid",3);
	} 
	

	/**
	 * Method to get final report
	 * 
	 * @param request
	 * @return GetFinalReportResponse
	 */
	@RequestMapping(value= "/getFinalReport",
			produces = "application/json",
			method= RequestMethod.POST)
	public GetFinalReportResponse getFinalReport(@RequestBody GetFinalReportRequest request) {
		logger.info("[ReceptoresController] - getFinalReports() invoked... "+request);
		return new GetFinalReportResponse("Any String you want".getBytes(),"Algo de datos");
	} 
}
