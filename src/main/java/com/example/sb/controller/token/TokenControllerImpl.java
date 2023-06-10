package com.example.sb.controller.token;

import com.example.sb.dto.token.JwtRequest;
import com.example.sb.service.token.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenControllerImpl implements TokenController {

    private final TokenServiceImpl tokenService;

    @Autowired
    public TokenControllerImpl(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest) {
        return tokenService.createToken(jwtRequest);
    }

}
