package com.example.examspringfundskeleton.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDto {

    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
