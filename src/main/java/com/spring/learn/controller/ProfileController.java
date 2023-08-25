package com.spring.learn.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface ProfileController {

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/access")
    ResponseEntity<String> IhaveAccess();

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/root")
    ResponseEntity<String> IdontHaveIt();
}
