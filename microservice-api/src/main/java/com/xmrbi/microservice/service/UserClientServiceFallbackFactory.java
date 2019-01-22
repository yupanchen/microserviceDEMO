package com.xmrbi.microservice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xmrbi.microservice.entities.User;

import feign.hystrix.FallbackFactory;

@Component
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService>{

	@Override
	public UserClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new UserClientService() {

			@Override
			public User get(long id) {
				return new User().setUser_id(id)
			               .setName("该Id："+id+"没有对用的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
			               .setDb_source("no this database in MySQL");
			}

			@Override
			public List<User> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(User user) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
