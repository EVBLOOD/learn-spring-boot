package com.spring.learn.model;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import jakarta.persistence.*;
import lombok.*;

@Audited
@Entity
@Table(name = "b_user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_name")
    String userName;

    @Column(name =  "user_passowrd")
    String Password;

    @Column(name = "user_fullname")
    String fullName;

    @Column(name =  "user_role")
    @Enumerated(EnumType.STRING)
    com.spring.learn.ressources.Role rule;

    @Column(name= "user_locked")
    boolean Locked;

    @OneToOne(mappedBy = "user")
    @NotAudited
    TokenEntity token;

}
