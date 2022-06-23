package com.example.battleShips.currUser;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLogged(){
        return this.id != null;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
