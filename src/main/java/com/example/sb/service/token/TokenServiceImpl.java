package com.example.sb.service.token;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.token.JwtRequest;
import com.example.sb.service.user.UserServiceImpl;
import com.example.sb.util.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {

    private final UserServiceImpl userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public TokenServiceImpl(UserServiceImpl userService, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }



    @Override
    public ResponseEntity<?> createToken(JwtRequest jwtRequest) {
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
