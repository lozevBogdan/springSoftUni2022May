package com.example.battleShips.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDto {


    @NotNull
    @Size(min = 3, max = 10)
    private String username;


    @NotNull
    @Size(min = 3)
    private String password;


    public UserLoginDto() {
    }

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
