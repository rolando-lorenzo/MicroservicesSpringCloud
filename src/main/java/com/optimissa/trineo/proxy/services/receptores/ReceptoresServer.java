package com.optimissa.trineo.proxy.services.receptores;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.optimissa.trineo.proxy.receptores.config.ReceptoresConfig;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link ReceptoresConfig}. This is a deliberate separation of concerns.
 * 
 * @author Rolando Lorenzo Lopez
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ReceptoresConfig.class)
public class ReceptoresServer {
	
	protected Logger logger = Logger.getLogger(ReceptoresServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "receptores-server");
		SpringApplication.run(ReceptoresServer.class, args);
	}

}
