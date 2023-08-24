package com.spring.learn.service;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;

public interface UserService {
    String LoginWithPassword(UserLoginRequest existingUser)  throws Exception ;
    String RegisterNewUser(NewUserRequest newUser)  throws Exception ;
}
