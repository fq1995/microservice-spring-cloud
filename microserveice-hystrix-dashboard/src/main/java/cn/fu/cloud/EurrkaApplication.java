package cn.fu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class EurrkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurrkaApplication.class, args);
	}
}
