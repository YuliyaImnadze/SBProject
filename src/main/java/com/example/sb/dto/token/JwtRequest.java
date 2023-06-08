package com.example.sb.dto.token;

import lombok.Data;

@Data
public class JwtRequest {

    private String login;
    private String password;

}
