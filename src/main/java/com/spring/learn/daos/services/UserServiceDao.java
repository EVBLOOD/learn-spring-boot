package com.spring.learn.daos.services;

import com.spring.learn.model.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public interface UserServiceDao {
    UserEntity save(UserEntity user);
    UserEntity findOne(Specification<UserEntity> specification);

}
