package com.fu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class TestConfig {
	@Autowired
	IClientConfig iClientConfig;
	
	@Bean
	public IRule ribbonRule(IClientConfig iClientConfig){
		return new RandomRule();
	}
}
