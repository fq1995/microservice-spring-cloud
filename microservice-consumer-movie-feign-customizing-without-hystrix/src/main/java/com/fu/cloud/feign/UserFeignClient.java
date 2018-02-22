package com.fu.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.fu.cloud.entity.User;
import com.fu.config.Configuration1;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-privider-user", configuration = Configuration1.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
}
