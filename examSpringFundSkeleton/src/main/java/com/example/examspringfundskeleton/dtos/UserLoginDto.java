package com.example.examspringfundskeleton.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginDto {


    @NotEmpty
    @Size(min = 3,max = 20,message = "Username shouls be between 3 and 20 characters!")
    private String username;

    @NotEmpty
    @Size(min = 3,max = 20)
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
