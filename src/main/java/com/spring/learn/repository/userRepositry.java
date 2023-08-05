package com.spring.learn.repository;

import com.spring.learn.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepositry extends JpaRepository<UserEntity, Long> {
}
