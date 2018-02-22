# microservice-simple-consumer-movie
	<dependency>
			<groupId>org.springframework.cloud</groupId>		
			<artifactId>spring-cloud-starter-hystrix</artifactId>
	</dependency>

	@EnableCircuitBreaker
	public class ConsumerMovieRibbonApplication {}

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
