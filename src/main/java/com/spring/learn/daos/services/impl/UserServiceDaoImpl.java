package com.spring.learn.daos.services.impl;

import com.spring.learn.daos.repositories.UserRepository;
import com.spring.learn.daos.services.UserServiceDao;
import com.spring.learn.model.UserEntity;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceDaoImpl implements UserServiceDao {
    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findOne(Specification<UserEntity> specification) {
        return userRepository.findOne(specification).orElse(null);
    }

    // @Override
    public Optional<UserEntity> justFindOne(Specification<UserEntity> specification) {
        return userRepository.findOne(specification);
    }
}
