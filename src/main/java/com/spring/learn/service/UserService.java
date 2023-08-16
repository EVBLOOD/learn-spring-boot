package com.spring.learn.service;

import com.spring.learn.model.UserEntity;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;

import java.util.Optional;

public interface UserService {
    String LoginWithPassword(UserLoginRequest existingUser)  throws Exception ;

    String RegisterNewUser(NewUserRequest newUser)  throws Exception ;
}
