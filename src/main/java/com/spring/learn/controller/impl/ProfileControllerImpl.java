package com.spring.learn.controller.impl;

import com.spring.learn.controller.ProfileController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileControllerImpl implements ProfileController {

    @Override
    public ResponseEntity<String> myUserName()
    {
        System.out.println("HOLO");
        return  ResponseEntity.ok( "authed");
    }

}
