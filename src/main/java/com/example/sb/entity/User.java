package com.example.sb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Objects;



@Entity(name = "SB_USER")
@Table(name = "sb_user")
public class User extends BaseEntity {

    @Column(name = "login", unique = true)
    @Size(min = 2, max = 20, message = "The length of the login must be in the range from 2 to 20 characters")
    private String login;

    @Size(min = 3, max = 20, message = "The length of the login must be in the range from 3 to 20 characters")
    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "first_name")
    @Size(min = 2, max = 20, message = "The length of the firstName must be in the range from 2 to 20 characters")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 20, message = "The length of the lastName must be in the range from 2 to 20 characters")
    private String lastName;

    @Column(name = "middle_name")
    @Size(min = 2, max = 20, message = "The length of the middleName must be in the range from 2 to 20 characters")
    private String middleName;

    @Column(name = "birth_date")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Column(name = "phone")
    @Pattern(regexp = "\\+7\\d{10}", message = "Invalid phone number format")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    @Email
    private String email;

    @CreatedDate
    @Column(name = "created_when")
    private LocalDate createdWhen;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(LocalDate createdWhen) {
        this.createdWhen = createdWhen;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(middleName, user.middleName) && Objects.equals(birthDate, user.birthDate) && Objects.equals(phone, user.phone) && Objects.equals(address, user.address) && Objects.equals(email, user.email) && Objects.equals(createdWhen, user.createdWhen) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, firstName, lastName, middleName, birthDate, phone, address, email, createdWhen, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", createdWhen=" + createdWhen +
                ", role=" + role +
                '}';
    }


}
