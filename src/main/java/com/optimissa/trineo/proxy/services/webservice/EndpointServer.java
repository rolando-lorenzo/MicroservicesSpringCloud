package com.optimissa.trineo.proxy.services.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.optimissa.trineo.proxy.gateway.controller.MicroserviceGatewayController;
import com.optimissa.trineo.proxy.gateway.service.MicroserviceGatewayService;
import com.optimissa.trineo.proxy.gateway.service.impl.MicroserviceGatewayServiceImpl;

/**
 * MicroserviceGateway. Works as a microservice client, fetching data from the
 * RECEPTORES-SERVICE. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 * @author Rolando Lorenzo Lopez
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class EndpointServer {
	
	/**
	 * URL uses the logical name of receptores-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String RECEPTORES_SERVICE_URL = "http://RECEPTORES-SERVICE";

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(EndpointServer.class, args);
	}

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton" 
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * The MicroserviceGatewayService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
	@Bean
	public MicroserviceGatewayService microserviceGatewayService() {
		return new MicroserviceGatewayServiceImpl(RECEPTORES_SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link MicroserviceGatewayService} to use.
	 * 
	 * @return
	 */
	@Bean
	public MicroserviceGatewayController microserviceGatewayController() {
		return new MicroserviceGatewayController(microserviceGatewayService());
	}
	
}
