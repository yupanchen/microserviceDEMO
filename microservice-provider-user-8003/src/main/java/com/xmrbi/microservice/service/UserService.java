package com.xmrbi.microservice.service;

import java.util.List;

import com.xmrbi.microservice.entities.User;

public interface UserService {

	public Boolean add(User user);
	public List<User> list();
	public User get(Long id);
}