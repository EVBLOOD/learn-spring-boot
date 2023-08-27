package com.spring.learn.service.impl;
import com.spring.learn.model.UserEntity;
import com.spring.learn.config.AppUserDetails;
import com.spring.learn.daos.services.UserServiceDao;
import com.spring.learn.daos.specification.UserSpecification;
import com.spring.learn.mapper.UserMapper;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.Role;
import com.spring.learn.ressources.UserLoginRequest;
import com.spring.learn.service.UserService;
import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Optional;

// @Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    // private final UserRepository userRepo;
    private final UserServiceDao userServiceDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    // private final Logger logger = 

    // private UserEntity save(UserEntity UserX) {
    //     return userServiceDao.save(UserX);
    // }
    
    @Override
    public String LoginWithPassword(UserLoginRequest existingUser) throws RuntimeException {
        // log.info("info");
        // log.error("error");
        // log.warn("warn");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        existingUser.getUserName(),
                        existingUser.getPassword()));
        Optional<UserEntity> NewOne = userServiceDao.justFindOne(
            UserSpecification
            .withName(existingUser
            .getUserName()));
        if (!NewOne.isPresent())
            throw new RuntimeException("NOPE!");
        return jwtService.GenerateToken(new HashMap<>(), new AppUserDetails(NewOne.get()));
    }

    @Override
    public String RegisterNewUser(NewUserRequest newUser)
        throws RuntimeException {

        Optional<UserEntity> user = userServiceDao
        .justFindOne(UserSpecification.withName(newUser.getUserName()));

        if (user.isPresent())
            throw new RuntimeException("UserName Not Unique!");

        UserEntity NewOne = userMapper.DtoRegisterToEntity(newUser);

        NewOne.setPassword(passwordEncoder.encode(newUser.getPassword()));
        NewOne.setRule(Role.USER);
        this.userServiceDao.save(NewOne);

        return jwtService.GenerateToken(new HashMap<>(), new AppUserDetails(NewOne));
    }
}
