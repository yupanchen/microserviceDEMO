package com.xmrbi.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public User get(@PathVariable("id") Long id) {
		return userservice.get(id);
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<User> list() {
		return userservice.list();
	}

}
