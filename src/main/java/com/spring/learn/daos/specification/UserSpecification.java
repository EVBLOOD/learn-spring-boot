package com.spring.learn.daos.specification;

import com.spring.learn.model.UserEntity;
//import com.spring.learn.model.UserEntity_;

import com.spring.learn.model.UserEntity_;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    static public Specification<UserEntity> withId(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserEntity_.id), id);
    }

    static public Specification<UserEntity> withName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserEntity_.userName), name);
    }
}
