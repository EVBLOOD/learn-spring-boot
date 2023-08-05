package com.spring.learn.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "b_user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_name")
    String userName;

    @OneToOne(mappedBy = "user")
    TokenEntity token;
}
