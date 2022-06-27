package com.example.battleShips.dtos;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDto {


    @NotNull
    @Size(min = 3, max = 10)
    private String username;

    @NotNull
    @Size(min = 5, max = 20)
    private String fullName;

    @NotNull
    @Size(min = 3)
    private String password;

    @NotNull
    @Size(min = 3, max = 10)
    private String confirmPass;


    @NotNull
    @Email
    private String email;

    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public UserRegisterDto setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
