package com.spring.learn.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/User")
public interface ProfileController {

    @PreAuthorize("hasAnyRole('User')")
    @GetMapping("/MyInfos")
    ResponseEntity<String> myUserName();
}
