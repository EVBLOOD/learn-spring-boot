package com.spring.learn.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface JwtService {
     String ExtractUserNameFromToken(String Token);

     Claims ExtructClaims(String Token);

     String GenerateToken(Map<String, Object> extraClaims, UserDetails userDetails);

     Boolean IsTokenValid(String token, UserDetails userDetails);


}
