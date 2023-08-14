package com.spring.learn.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "b_token")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "token")
    String Token;

    @Column(name = "date")
    Date ExpireDate;

    @OneToOne()
    @JoinColumn(name =  "UserID", referencedColumnName = "id")
    UserEntity user;
}
