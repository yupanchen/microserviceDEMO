package com.xmrbi.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xmrbi.microservice.entities.User;

@RestController
public class UserController_consumer {
	
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICE-PROVIDER-USER";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value="/consumer/user/add")
    public boolean add(User user){
         return restTemplate.postForObject(REST_URL_PREFIX+"/user/add", user, Boolean.class);
    }
    
    @RequestMapping(value="/consumer/user/get/{id}")
    public User get(@PathVariable("id") Long id){
         return restTemplate.getForObject(REST_URL_PREFIX+"/user/get/"+id, User.class);
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/user/list")
    public List<User> list(){
         return restTemplate.getForObject(REST_URL_PREFIX+"/user/list", List.class);
    }
}
