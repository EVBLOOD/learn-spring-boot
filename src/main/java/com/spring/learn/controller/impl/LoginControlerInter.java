package com.spring.learn.controller.impl;

import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface LoginControlerInter {
    @PostMapping("/login")
    ResponseEntity<UserEntity> LoginWithPassword(@RequestBody() UserLoginRequest newUser);

    @PostMapping("/register")
    ResponseEntity<UserEntity> RegisterNewUser(@RequestBody() NewUserRequest newUser);
}
