package com.example.sb.service.token;

import com.example.sb.dto.token.JwtRequest;
import com.example.sb.dto.token.JwtResponse;
import com.example.sb.service.user.UserServiceImpl;
import com.example.sb.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


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
    public JwtResponse createToken(JwtRequest jwtRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getLogin(), jwtRequest.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getLogin());
        String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }


}
