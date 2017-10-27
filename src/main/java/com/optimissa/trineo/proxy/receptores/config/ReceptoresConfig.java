package com.optimissa.trineo.proxy.receptores.config;

import java.util.Arrays;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class of microservice application
 * 
 * @author Rolando Lorenzo 
 *
 */
@Configuration
@ComponentScan("com.optimissa.trineo.proxy.receptores")
@PropertySource("classpath:app-receptores-config.properties")
public class ReceptoresConfig {
	
	/**
	 * Usuario server backend .NET
	 */
	@Value( "${receptores.config.serverbackend.user}" )
	private String user;
	

	/**
	 * password server backend .NET
	 */
	@Value( "${receptores.config.serverbackend.pass}" )
	private String password;
	
	/** 
	 * RestTemplate para cliente Backend en .NET
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate restTemplateClientDotNet() {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
	    credsProvider.setCredentials(
	        new AuthScope(AuthScope.ANY),new NTCredentials(user, password, "", ""));
	    RequestConfig config = RequestConfig.custom().setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM)).build();
	    
	    CloseableHttpClient httpclient = HttpClients.custom()
	    	.setDefaultRequestConfig(config)
	        .setDefaultCredentialsProvider(credsProvider)
	        .build();
	    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpclient);
	    RestTemplate restTemplateClientDotNet = new RestTemplate(requestFactory);
	    restTemplateClientDotNet.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplateClientDotNet.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplateClientDotNet;
	}
}
