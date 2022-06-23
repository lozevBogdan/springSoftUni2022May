package com.example.battleShips.entity;

import com.example.battleShips.entity.enums.CategoryEnums;

import javax.persistence.*;

@Table(name = "categories")
@Entity
public class CategoryEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private CategoryEnums name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }

    public CategoryEnums getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnums name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
