package com.xmrbi.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul9527StartApp {
	public static void main(String[] args) {
		SpringApplication.run(Zuul9527StartApp.class, args);
	}
}
