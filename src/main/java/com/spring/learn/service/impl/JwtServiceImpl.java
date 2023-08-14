package com.spring.learn.service.impl;

import com.spring.learn.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {



    @Value("${spring.security.secret-key}")
    private String secretKey;
    @Override
    public String ExtractUserNameFromToken(String Token) {
        return extractClaims(Token, Claims::getSubject);
    }

    private <T> T extractClaims(String Token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = ExtructClaims(Token);
        return  claimsResolver.apply(claims);
    }


    @Override
    public Claims ExtructClaims(String Token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey())
                .build().parseClaimsJws(Token)
                .getBody();
    }

    @Override
    public String GenerateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().addClaims(extraClaims).setSubject(userDetails.getUsername()).
                setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)).signWith(getSigningKey())
                .compact();
    }

    Boolean IsTokenExpired(String token)
    {
        return  ExtructExperationDate(token).before(new Date());
    }
    Date ExtructExperationDate(String token)
    {
        return  extractClaims(token, Claims::getExpiration);
    }

    @Override
    public Boolean IsTokenValid(String token, UserDetails userDetails) {
        String UserName = ExtractUserNameFromToken(token);
        return userDetails.getUsername().equals(UserName) &&  !IsTokenExpired(token);
    }

    Key getSigningKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(KeyBytes);
    }


}
