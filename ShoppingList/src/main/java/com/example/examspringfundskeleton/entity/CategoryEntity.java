package com.example.examspringfundskeleton.entity;

import javax.persistence.*;

@Table(name="categories")
@Entity
public class CategoryEntity extends BaseEntity {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(nullable = false)
    private String description;

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
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
