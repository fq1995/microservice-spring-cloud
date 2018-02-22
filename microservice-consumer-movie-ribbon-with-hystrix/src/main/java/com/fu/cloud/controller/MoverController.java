package com.fu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fu.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MoverController {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "findByIdfallback")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://microservice-privider-user:8080/simple/"+ id, User.class);
	}

	public User findByIdfallback(Long id){
		User user = new User();
		user.setId(0L);
		return user;
	}
	
	@GetMapping("/test")
	public String testConfig(){
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-privider-user");
		System.out.println("---"+serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());
		
		ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-privider-user2");
		System.out.println("***"+serviceInstance2.getServiceId()+":"+serviceInstance2.getHost()+":"+serviceInstance2.getPort());
		
		return "0";
	}
	
}
