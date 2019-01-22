package com.xmrbi.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xmrbi.microservice.entities.User;
import com.xmrbi.microservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public boolean add(@RequestBody User user) {
		return userservice.add(user);
	}

	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public User get(@PathVariable("id") Long id) {
		
		User user = this.userservice.get(id);
		if(null == user) 
			throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		
		return user;
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<User> list() {
		return userservice.list();
	}
	
	public User processHystrix_Get(@PathVariable("id") Long id){
	   return new User().setUser_id(id)
	           .setName("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
	           .setDb_source("no this database in MySQL");
	}
}
