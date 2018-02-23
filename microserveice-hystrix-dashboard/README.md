# microserveice-hystrix-dashboard

@SpringBootApplication
@EnableHystrixDashboard
public class EurrkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurrkaApplication.class, args);
	}
}

<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>