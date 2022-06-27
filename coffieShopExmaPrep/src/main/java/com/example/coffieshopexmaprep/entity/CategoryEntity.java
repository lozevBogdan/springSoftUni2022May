package com.example.coffieshopexmaprep.entity;

import com.example.coffieshopexmaprep.entity.enums.CategoryEnum;

import javax.persistence.*;
import java.util.*;

@Table(name = "categories")
@Entity
public class CategoryEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(nullable = false)
    private Integer neededTime;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public CategoryEntity() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public CategoryEntity setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
