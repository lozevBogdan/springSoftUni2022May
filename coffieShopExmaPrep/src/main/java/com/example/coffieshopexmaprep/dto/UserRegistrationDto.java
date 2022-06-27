package com.example.coffieshopexmaprep.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

    private Long id;

    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    private String firstName;

    @NotNull
    @Size(min = 5, max = 20)
    private String lastName;

    @Email
    private String email;

    @NotNull
    @Size(min = 3)
    private String password;

    @NotNull
    @Size(min = 3)
    private String confirmPassword;

    public UserRegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserRegistrationDto setId(Long id) {
        this.id = id;
        return this;
    }
}
