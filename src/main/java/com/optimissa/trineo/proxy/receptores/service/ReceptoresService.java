package com.optimissa.trineo.proxy.receptores.service;

import java.util.List;

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

/**
 * Interface Consumes backend client from .NET platform
 * 
 * @author Rolando Lorenzo Lopez
 */
public interface ReceptoresService {
	
	/**
	 * Get all Sectores
	 * @return ValidarReceptorResponse 
	 */
	ValidarReceptorResponse validateReceptor(Receptor receptor); 
	
	
	/**
	 * Forgotten password
	 * @return ValidarReceptorResponse 
	 */
	ConfirmResponse forgottenPassword(Receptor receptor); 
	
	
	/**
	 * Change password
	 * @return ValidarReceptorResponse 
	 */
	ConfirmResponse changePassword(Receptor receptor); 
	
	/**
	 * update Receptor
	 * @return ValidarReceptorResponse 
	 */
	ConfirmResponse updateReceptor(Receptor receptor); 
	
	/**
	 * Get identifiaciones
	 * @return List<TipoIdentificacion> identifiaciones list
	 */
	List<TipoIdentificacion> getIdentificacion();
	
	/**
	 * Get Nacionalidad
	 * @return List<Nacionalidad> Nacionalidad list
	 */
	List<Nacionalidad> getNacionalidad();
	
	/**
	 * Get Idioma
	 * @return List<Nacionalidad> Idioma list
	 */
	List<Idioma> getIdioma();
	
	/**
	 * Get ClasificaInforme
	 * @return List<Nacionalidad> Idioma list
	 */
	List<ClasificaInforme> clasificaInforme();
	
	/**
	 * Get all Sectores
	 * @return List<Sector> sectores list
	 */
	List<Sector> getAllSectores(); 
	
	/**
	 * Get report types
	 * @return List<ReportTypeSubscribe> Report Type Subscribe list
	 */
	List<ReportTypeSubscribe> getReportTypes(String receptorId); 
	
	
	/**
	 * Set ALerts
	 * @return List<ReportTypeSubscribe> Report Type Subscribe list
	 */
	void setAlerts(Alert alerts);
	
	

}
