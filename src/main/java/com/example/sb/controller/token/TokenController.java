package com.example.sb.controller.token;

import com.example.sb.dto.token.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TokenController {

    @PostMapping("/token")
    ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest);

}
