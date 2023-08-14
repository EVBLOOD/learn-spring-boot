package com.spring.learn.controller.impl;

import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController

//@RequestMapping("/login")
public interface LoginControlerInter {
    @PostMapping
    ResponseEntity<UserEntity> LoginWithPassword(@RequestBody() UserLoginRequest newUser);

    @PostMapping
    ResponseEntity<UserEntity> RegisterNewUser(@RequestBody() NewUserRequest newUser);
}
