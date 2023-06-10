package com.example.sb.service.token;

import com.example.sb.dto.token.JwtRequest;
import org.springframework.http.ResponseEntity;

public interface TokenService {

    ResponseEntity<?> createToken(JwtRequest jwtRequest);

}
