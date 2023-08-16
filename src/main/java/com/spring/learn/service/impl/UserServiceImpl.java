package com.spring.learn.service.impl;
import com.spring.learn.model.UserEntity;
import com.spring.learn.daos.repositories.UserRepository;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.Role;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private  final  PasswordEncoder passwordEncoder;
    private  final  JwtServiceImpl jwtService;
    private  final AuthenticationManager authenticationManager;


    private UserEntity save(UserEntity UserX)
    {
        return userRepo.save(UserX);
    }

    @Override
    public String LoginWithPassword(UserLoginRequest existingUser)   throws RuntimeException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        existingUser.getUserName(),
                        existingUser.getPassword()));
        Optional<UserEntity> NewOne = userRepo.findByUserName(existingUser.getUserName());
        if (!NewOne.isPresent())
            throw new RuntimeException("NOPE!");
        return  jwtService.GenerateToken(new HashMap<>(), NewOne.get());
    }

    @Override
    public String RegisterNewUser(NewUserRequest newUser)  throws RuntimeException {
        Optional<UserEntity> user = userRepo.findByUserName(newUser.getUserName());
        if (user.isPresent())
            throw new RuntimeException("UserName Not Unique!");
        UserEntity NewOne = new UserEntity();
        NewOne.setUserName(newUser.getUserName());
        NewOne.setPassword(passwordEncoder.encode(newUser.getPassword()));
        NewOne.setRole(Role.User);
        this.userRepo.save(NewOne);
        return   jwtService.GenerateToken(new HashMap<>(), NewOne);
    }



}
