package com.example.sb.controller;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.token.JwtRequest;
import com.example.sb.security.JwtTokenUtil;
import com.example.sb.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TokenController {

    private final UserServiceImpl userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public TokenController(UserServiceImpl userService, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public ResponseEntity<?> createToken(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getLogin(), jwtRequest.getPassword()));
        } catch (BadCredentialsException exception) {
            BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.UNAUTHORIZED, "Invalid login or password", LocalDateTime.now());
            return ResponseEntity.ok(tBaseResponse);
        }
        UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getLogin());
        String token = jwtTokenUtil.generateToken(userDetails);
        BaseResponse<?> tBaseResponse = new BaseResponse<>(HttpStatus.OK, token, LocalDateTime.now());
        return ResponseEntity.ok(tBaseResponse);
    }

}
