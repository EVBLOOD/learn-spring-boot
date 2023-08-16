package com.spring.learn.controller;

import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface LoginController {
    @PostMapping("/login")
    ResponseEntity<String> LoginWithPassword(@RequestBody UserLoginRequest newUser);

    @PostMapping("/register")
    ResponseEntity<String> RegisterNewUser(@RequestBody NewUserRequest newUser);
}
