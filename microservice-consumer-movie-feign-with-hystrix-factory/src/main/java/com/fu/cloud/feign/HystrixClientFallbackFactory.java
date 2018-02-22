package com.fu.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fu.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient>{

	private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
	@Override
	public UserFeignClient create(Throwable cause) {
		logger.info("cause: {}",cause.getMessage());
		return new UserFeignClientWithFactory(){
			
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}
			
		};
	}

}
