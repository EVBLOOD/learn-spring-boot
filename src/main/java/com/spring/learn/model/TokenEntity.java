package com.spring.learn.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "b_token")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "token")
    String Token;

    @OneToOne()
    @JoinColumn(name =  "UserID", referencedColumnName = "id")
    UserEntity user;
}
