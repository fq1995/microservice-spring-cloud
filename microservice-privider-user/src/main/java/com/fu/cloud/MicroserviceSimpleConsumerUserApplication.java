package com.fu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSimpleConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerUserApplication.class, args);
	}
}
