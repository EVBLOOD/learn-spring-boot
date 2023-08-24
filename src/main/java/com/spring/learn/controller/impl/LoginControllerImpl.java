package com.spring.learn.controller.impl;
import com.spring.learn.controller.LoginController;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

    private final UserServiceImpl userServ;

    @Override
    public ResponseEntity<String> LoginWithPassword(UserLoginRequest ExistingUser){
        try
        {
            String UserLog = userServ.LoginWithPassword(ExistingUser);
            return ResponseEntity.ok(UserLog);
        }
        catch (Exception err)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<String> RegisterNewUser(NewUserRequest newUser) {
        try {
            String UserLog = userServ.RegisterNewUser(newUser);
            return ResponseEntity.ok(UserLog);
        }
        catch (Exception err)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
