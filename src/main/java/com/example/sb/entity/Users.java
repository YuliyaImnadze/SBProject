package com.example.sb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    @Column
    private String login;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
//    @Pattern(regexp = "\\+7\\d{10}", message = "Invalid phone number format")
    private String phone;

    @Column
    private String address;

    @Column
//    @Email
    private String email;

    @CreatedDate
    @Column(name = "created_when")
    private LocalDate createdWhen;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

}
