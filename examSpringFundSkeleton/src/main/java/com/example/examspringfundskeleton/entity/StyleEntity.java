package com.example.examspringfundskeleton.entity;

import javax.persistence.*;

@Table(name = "styles")
@Entity
public class StyleEntity extends BaseEntity  {

    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    private StyleEnum name;

    private String description;

    public StyleEnum getName() {
        return name;
    }

    public StyleEntity setName(StyleEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StyleEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
