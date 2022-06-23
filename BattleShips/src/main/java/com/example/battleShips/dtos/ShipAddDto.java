package com.example.battleShips.dtos;

import com.example.battleShips.entity.CategoryEntity;
import com.example.battleShips.entity.UserEntity;
import com.example.battleShips.entity.enums.CategoryEnums;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class ShipAddDto {

    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @NotNull
    private CategoryEnums category;

    public ShipAddDto() {
    }

    public String getName() {
        return name;
    }

    public ShipAddDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipAddDto setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipAddDto setPower(Long power) {
        this.power = power;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ShipAddDto setCreated(Date created) {
        this.created = created;
        return this;
    }

    public CategoryEnums getCategory() {
        return category;
    }

    public ShipAddDto setCategory(CategoryEnums category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "ShipAddDto{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", power=" + power +
                ", created=" + created +
                ", category=" + category +
                '}';
    }
}
