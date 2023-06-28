package com.example.sb.controller.token;

import com.example.sb.dto.BaseResponse;
import com.example.sb.dto.token.JwtRequest;
import com.example.sb.dto.token.JwtResponse;
import com.example.sb.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenControllerImpl implements TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenControllerImpl(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<BaseResponse<JwtResponse>> createToken(@RequestBody JwtRequest jwtRequest) {
        JwtResponse token = tokenService.createToken(jwtRequest);
        BaseResponse<JwtResponse> tBaseResponse = new BaseResponse<>(HttpStatus.OK, token);
        return ResponseEntity.ok(tBaseResponse);
    }


}
