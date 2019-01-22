package com.xmrbi.microservice.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmrbi.microservice.entities.User;


@FeignClient(value = "MICROSERVICE-PROVIDER-USER",
	fallbackFactory=UserClientServiceFallbackFactory.class)
public interface UserClientService {
	
	  @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
	  public User get(@PathVariable("id") long id);
	 
	  @RequestMapping(value = "/user/list",method = RequestMethod.GET)
	  public List<User> list();
	 
	  @RequestMapping(value = "/user/add",method = RequestMethod.POST)
	  public boolean add(User user);
}
