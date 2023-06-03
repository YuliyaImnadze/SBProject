package com.example.sb.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sb_user")
public class User extends BaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone")
//    @Pattern(regexp = "\\+7\\d{10}", message = "Invalid phone number format")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
//    @Email
    private String email;

    @CreatedDate
    @Column(name = "created_when")
    private LocalDate createdWhen;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

}
