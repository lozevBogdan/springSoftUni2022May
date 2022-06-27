package com.example.battleShips.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "ships")
@Entity
public class ShipEntity extends BaseEntity {


    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private Long health;

    @Column(nullable = false)
    private Long power;

    @Column(nullable = false)
    private Date created;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private UserEntity user;

    public ShipEntity() {
    }

    public String getName() {
        return name;
    }

    public ShipEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipEntity setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipEntity setPower(Long power) {
        this.power = power;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ShipEntity setCreated(Date created) {
        this.created = created;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ShipEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ShipEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
