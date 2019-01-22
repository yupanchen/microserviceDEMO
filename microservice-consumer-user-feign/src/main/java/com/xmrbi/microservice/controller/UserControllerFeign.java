package com.xmrbi.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmrbi.microservice.entities.User;
import com.xmrbi.microservice.service.UserClientService;

@RestController
public class UserControllerFeign {
    
    @Autowired
    private UserClientService userService = null;
    
    @RequestMapping(value="/consumer/user/add")
    public boolean add(User user){
         return this.userService.add(user);
    }
    
    @RequestMapping(value="/consumer/user/get/{id}")
    public User get(@PathVariable("id") Long id){
         return this.userService.get(id);
    }
    
    @RequestMapping(value="/consumer/user/list")
    public List<User> list(){
         return this.userService.list();
    }

}
