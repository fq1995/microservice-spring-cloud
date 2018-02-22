package com.fu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fu.cloud.entity.User;
import com.fu.cloud.feign.FeignClient2;
import com.fu.cloud.feign.UserFeignClient;

@RestController
public class MoverController {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private FeignClient2 feginClient2;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return userFeignClient.findById(id);
//		return this.restTemplate.getForObject(userServerPath+ id, User.class);
	}
	
	@RequestMapping(value = "/{serviceName}", method = RequestMethod.GET)
	public String findServiceInfoFromEureka(@PathVariable String serviceName){
		return feginClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
}
