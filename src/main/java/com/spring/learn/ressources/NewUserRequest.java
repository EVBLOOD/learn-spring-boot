package com.spring.learn.ressources;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewUserRequest {
    String UserName;
    String Password;
    String FullName;
}
