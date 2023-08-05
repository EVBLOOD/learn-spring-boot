package com.spring.learn.controller;

import com.spring.learn.controller.impl.loginControlerInter;
import com.spring.learn.model.UserEntity;
import com.spring.learn.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController(value = "/lo)
@RestController

@RequestMapping("/login")

public class loginController implements loginControlerInter {

    @Autowired
    private userService userServ;
    @Override
    public UserEntity save(@RequestBody() UserEntity newUser)
    {
        return userServ.save(newUser);
//        return newUser;
    }

}
