package com.spring.learn.controller.impl;

import com.spring.learn.model.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController

//@RequestMapping("/login")
public interface loginControlerInter {
    @PostMapping
    UserEntity save(@RequestBody() UserEntity newUser);
}
