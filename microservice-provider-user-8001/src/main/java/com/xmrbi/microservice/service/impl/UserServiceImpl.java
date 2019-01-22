package com.xmrbi.microservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmrbi.microservice.dao.UserDao;
import com.xmrbi.microservice.entities.User;
import com.xmrbi.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public Boolean add(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<User> list() {
		return userDao.findAll();
	}

	@Override
	public User get(Long id) {
		return userDao.findById(id);
	}

}
