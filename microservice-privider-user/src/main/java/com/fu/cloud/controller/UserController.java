package com.fu.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fu.cloud.entity.User;
import com.fu.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private Registration registration;
	
 	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
	
	/**
	 * 
	 * @return http://192.168.0.103:8080/
	 */
	@GetMapping("/eureka-instance")
	public String serviceUrl(){
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("microservice-privider-user", false);
		return instance.getHomePageUrl();
	}
	
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo(){
		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
//		List<String> serviceInstance = discoveryClient.getServices();
//		String serviceId = registration.getServiceId();
		return serviceInstance;
	}
	
}
