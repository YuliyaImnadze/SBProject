package com.example.sb.dto.user;


import com.example.sb.dto.base.BaseEntityDtoRequest;
import com.example.sb.dto.role.RoleDtoRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.sb.entity.User}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDtoRequest extends BaseEntityDtoRequest {

    @Size(min = 2, max = 20, message = "The length of the login must be in the range from 2 to 20 characters")
    private String login;

    @Size(min = 3, max = 20, message = "The length of the login must be in the range from 3 to 20 characters")
    private String password;

    @Size(min = 2, max = 20, message = "The length of the firstName must be in the range from 2 to 20 characters")
    private String firstName;

    @Size(min = 2, max = 20, message = "The length of the lastName must be in the range from 2 to 20 characters")
    private String lastName;

    @Size(min = 2, max = 20, message = "The length of the middleName must be in the range from 2 to 20 characters")
    private String middleName;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Pattern(regexp = "\\+7\\d{10}", message = "Invalid phone number format")
    private String phone;

    private String address;

    @Email
    private String email;

    private RoleDtoRequest role;
}