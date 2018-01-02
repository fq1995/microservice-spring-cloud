package com.fu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fu.cloud.entity.User;

@RestController
public class MoverController {
	
	@Value(value = "${user.userServerPath}")
	private String userServerPath;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject(userServerPath+ id, User.class);
	}
	
}
