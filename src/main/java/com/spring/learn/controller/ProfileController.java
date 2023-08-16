package com.spring.learn.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/User")
public interface ProfileController {

    @GetMapping("/MyInfos")
    ResponseEntity<String> myUserName();
}
