package com.example.sb.service.token;

import com.example.sb.dto.token.JwtRequest;
import com.example.sb.dto.token.JwtResponse;

public interface TokenService {

    JwtResponse createToken(JwtRequest jwtRequest);

}
