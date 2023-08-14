package com.spring.learn.service;

import com.spring.learn.model.UserEntity;
import com.spring.learn.repository.UserRepository;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.Role;
import com.spring.learn.ressources.UserLoginRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements com.spring.learn.service.impl.UserService {
    UserRepository userRepo;
    @Override
    public UserEntity save(UserEntity UserX)
    {
        return userRepo.save(UserX);
    }

    @Override
    public Optional<UserEntity> LoginWithPassword(UserLoginRequest existingUser) { // TODO: the function should return a token!
        // get the user by UserName first
        Optional<UserEntity> user = userRepo.findByUserName(existingUser.getUserName());
        if (user.isEmpty())
            return  null;
        // check for equality with pass
        if (user.get().getToken().equals(existingUser.getPassword())) // TODO: the password should be checked while hashed!
                return  user;
        return null;
    }

    @Override
    public UserEntity RegisterNewUser(NewUserRequest newUser) { // TODO: the function should return a token!

        // get the user by UserName first
        Optional<UserEntity> user = userRepo.findByUserName(newUser.getUserName());
        if (!user.isEmpty())
            return  null;
        UserEntity NewOne = new UserEntity();
        NewOne.setUserName(newUser.getUserName());
        NewOne.setPassword(newUser.getPassword()); // TODO: the password should be hashed!
        NewOne.setRole(Role.User);
        this.save(NewOne);
        return null;
    }

}
