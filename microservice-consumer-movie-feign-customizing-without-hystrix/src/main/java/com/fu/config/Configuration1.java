package com.fu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class Configuration1 {

	@Bean
	public Contract feignContract(){
		return new feign.Contract.Default();
	}
	
	@Bean
	public Logger.Level logLevel(){
		return Logger.Level.FULL;
	}
}
