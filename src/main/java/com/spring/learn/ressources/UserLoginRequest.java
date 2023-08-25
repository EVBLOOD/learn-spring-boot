package com.spring.learn.ressources;

import lombok.*;

@Data
public class UserLoginRequest {
    @NonNull
    String UserName;

    @NonNull
    String Password;
}
