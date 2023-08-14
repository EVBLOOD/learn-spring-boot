package com.spring.learn.service.impl;

import com.spring.learn.model.UserEntity;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> LoginWithPassword(UserLoginRequest existingUser);

    UserEntity RegisterNewUser(NewUserRequest newUser);
}
