package com.fu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
@Configuration
public class Configuration2 {

/*	@Bean
	public Contract feignContract(){
		return new SpringMvcContract();
	}*/
	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
		return new BasicAuthRequestInterceptor("user", "password");
	}
	
	@Bean
	public Logger.Level logLevel(){
		return Logger.Level.FULL;
	}
}
