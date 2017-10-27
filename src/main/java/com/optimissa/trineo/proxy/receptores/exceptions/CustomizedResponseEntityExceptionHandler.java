package com.optimissa.trineo.proxy.receptores.exceptions;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.optimissa.trineo.proxy.receptores.utils.ReceptoresUtils;


/**
 * Generic class to handle exceptions
 * 
 * @author Rolando Lorenzo
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Logger 
	 */
	protected Logger logger = Logger.getLogger(CustomizedResponseEntityExceptionHandler.class
			.getName());
	
	/**
     * Handle general exceptions
     */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
				"Error backend "+ex.getMessage(),
				request.getDescription(false));
		logger.log(Level.SEVERE,"Error general. "+ex.getMessage() +" - " +ReceptoresUtils.getStackTrace(ex.getStackTrace()));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
     * Handle failures commonly thrown from code
     */
    @ExceptionHandler({ InvocationTargetException.class, IllegalArgumentException.class, ClassCastException.class,
            ConversionFailedException.class })
    @ResponseBody
    public ResponseEntity<Object> handleMiscFailures(Throwable ex, WebRequest request) {
    	ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(),
				request.getDescription(false));
    	logger.log(Level.SEVERE,"Error programatico. "+ex.getMessage() +" - " +ReceptoresUtils.getStackTrace(ex.getStackTrace()));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle resource not found on Receptores
     */
	@ExceptionHandler(ReceptoresNotFoundException.class)
	@ResponseBody
	public final ResponseEntity<Object> handleUserNotFoundException(ReceptoresNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(),
				request.getDescription(false));
		logger.log(Level.SEVERE,"Error receptores. "+ex.getMessage() +" - " +ReceptoresUtils.getStackTrace(ex.getStackTrace()));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
     * Handle entity validators
     */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Validation Failed",
				ex.getBindingResult().toString());
		logger.log(Level.SEVERE,"Error en validacion. "+ex.getMessage() +" - " +ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	

}
