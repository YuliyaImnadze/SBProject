package com.example.sb.dto.user;


import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.role.RoleDtoRequest;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.sb.entity.User}
 */
@Data
public class UserDtoRequest  extends BaseEntityDtoRequest implements Serializable {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String email;
    private RoleDtoRequest role;
}