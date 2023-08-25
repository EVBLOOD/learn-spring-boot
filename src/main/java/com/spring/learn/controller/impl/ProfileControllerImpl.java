package com.spring.learn.controller.impl;

import com.spring.learn.controller.ProfileController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileControllerImpl implements ProfileController {


    @Override
    public ResponseEntity<String> IhaveAccess() {
                return  ResponseEntity.ok(" LOLO LOLO LOLO LOLO ");
    }

    @Override
    public ResponseEntity<String> IdontHaveIt() {
                return  ResponseEntity.ok(" (_) LOLO LOLO LOLO LOLO ");

    }

}
