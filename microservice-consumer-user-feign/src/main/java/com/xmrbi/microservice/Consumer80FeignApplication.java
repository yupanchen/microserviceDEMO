package com.xmrbi.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.xmrbi.microservice"})
@ComponentScan("com.xmrbi.microservice")

public class Consumer80FeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Consumer80FeignApplication.class, args);
	}

}
