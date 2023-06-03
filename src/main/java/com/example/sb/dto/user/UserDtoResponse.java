package com.example.sb.dto.user;


import com.example.sb.dto.BaseEntityDtoResponse;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDtoResponse extends BaseEntityDtoResponse implements Serializable {

    private String login;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String email;
    private LocalDate createdWhen;

}
