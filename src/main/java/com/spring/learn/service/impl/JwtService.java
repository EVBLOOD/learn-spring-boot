package com.spring.learn.service.impl;

import org.springframework.stereotype.Service;

@Service
public interface JwtService {
     String ExtractUserNameFromToken(String Token);

}
