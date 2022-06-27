package com.example.coffieshopexmaprep.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Target;
import java.util.*;

@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity{


    @Column(unique = true,nullable = false)
    private String username;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public UserEntity() {
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public UserEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
}
