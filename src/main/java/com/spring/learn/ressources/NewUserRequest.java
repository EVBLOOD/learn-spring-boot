package com.spring.learn.ressources;


import lombok.*;

@Data
public class  NewUserRequest {
    @NonNull
    String UserName;
    @NonNull
    String Password;
}
