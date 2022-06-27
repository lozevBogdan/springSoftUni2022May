package com.example.battleShips.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ShipsViewDto {

    private Long id;

    private String name;


    private Long health;


    private Long power;

    public ShipsViewDto() {
    }

    public Long getId() {
        return id;
    }

    public ShipsViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipsViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipsViewDto setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipsViewDto setPower(Long power) {
        this.power = power;
        return this;
    }
}
