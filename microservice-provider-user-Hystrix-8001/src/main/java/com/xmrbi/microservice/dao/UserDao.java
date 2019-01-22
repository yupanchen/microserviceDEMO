package com.xmrbi.microservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xmrbi.microservice.entities.User;

@Mapper
public interface UserDao {
	public User findById(Long id);
	public List<User> findAll();
	public Boolean addUser(User user);
}
