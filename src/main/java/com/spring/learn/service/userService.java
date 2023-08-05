package com.spring.learn.service;

import com.spring.learn.model.UserEntity;
import com.spring.learn.repository.userRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService implements com.spring.learn.service.impl.userService {

    @Autowired
    userRepositry userRepo;
    @Override
    public UserEntity save(UserEntity userx)
    {
        return userRepo.save(userx);
//        return userx;
    }

}
