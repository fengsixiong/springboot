package com.springboot.jap_demo.controller;

import com.springboot.jap_demo.entity.UserBean;
import com.springboot.jap_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findOne/{id}")
    public UserBean findOne(@PathVariable("id") String id) {
        return userService.findOne(id);
    }
}
