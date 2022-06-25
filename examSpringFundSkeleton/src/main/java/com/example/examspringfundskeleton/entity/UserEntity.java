package com.example.examspringfundskeleton.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String username;


    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true,nullable = false)
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<SongEntity> playlist = new LinkedList<>();


    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<SongEntity> getPlaylist() {
        return playlist;
    }

    public UserEntity setPlaylist(List<SongEntity> playlist) {
        this.playlist = playlist;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
