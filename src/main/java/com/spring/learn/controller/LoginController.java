package com.spring.learn.controller;

import com.spring.learn.controller.impl.LoginControlerInter;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.model.UserEntity;
import com.spring.learn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//@RestController(value = "/lo)
@RestController
@RequiredArgsConstructor
public class LoginController implements LoginControlerInter {

    private final UserService userServ;

    @Override
    public ResponseEntity<UserEntity> LoginWithPassword(UserLoginRequest ExistingUser){
        Optional<UserEntity> UserLog = userServ.LoginWithPassword(ExistingUser);
        return UserLog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }

    @Override
    public ResponseEntity<UserEntity> RegisterNewUser(NewUserRequest newUser) {
        UserEntity UserLog = userServ.RegisterNewUser(newUser);
        return ResponseEntity.ok(UserLog);
    }
}
