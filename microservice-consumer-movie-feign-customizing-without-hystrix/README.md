# microservice-simple-consumer-movie-feign-customizing-without-hystrix

方法1：
设置所有的hystrix不可用
  feign.hystrix.enabled=false 

方法2：
设置某个不可用
  在configuration类中添加
  	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}


默认是HystrixFeign.builder()，修改为Feign.builder();
	@Configuration
	@ConditionalOnClass({ HystrixCommand.class, HystrixFeign.class })
	protected static class HystrixFeignConfiguration {
		@Bean
		@Scope("prototype")
		@ConditionalOnMissingBean
		@ConditionalOnProperty(name = "feign.hystrix.enabled", matchIfMissing = false)
		public Feign.Builder feignHystrixBuilder() {
			return HystrixFeign.builder();
		}
	}