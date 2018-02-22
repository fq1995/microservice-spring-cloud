# microservice-simple-consumer-movie
microservice-privider-user:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
	<dependency>
			<groupId>org.springframework.cloud</groupId>		
			<artifactId>spring-cloud-starter-hystrix</artifactId>
	</dependency>