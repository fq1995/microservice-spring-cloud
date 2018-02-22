package com.fu.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fu.config.Configuration2;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class, fallback = FeignClient2Fallback.class)
public interface FeignClient2 {
	
	@RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
