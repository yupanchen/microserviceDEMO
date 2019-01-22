package com.xmrbi.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerDashBoardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerDashBoardApplication.class, args);
	}

}
