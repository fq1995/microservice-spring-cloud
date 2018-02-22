package com.fu.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fu.cloud.entity.User;

@FeignClient(name = "microservice-privider-user", fallbackFactory = HystrixClientFallbackFactory.class/*, fallback = HystrixClientFallback.class*/)
public interface UserFeignClient {

	//注意： @GetMapping不支持， @PathVariable必须写value值
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}
