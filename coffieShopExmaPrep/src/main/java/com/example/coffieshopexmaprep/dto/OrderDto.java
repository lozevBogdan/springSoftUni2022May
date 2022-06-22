package com.example.coffieshopexmaprep.dto;

import com.example.coffieshopexmaprep.entity.CategoryEntity;
import com.example.coffieshopexmaprep.entity.UserEntity;
import com.example.coffieshopexmaprep.entity.enums.CategoryEnum;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDto {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @PastOrPresent
    private LocalDateTime orderTime;

    @NotNull
    private CategoryEnum category;

    @Size(min = 5)
    private String description;

    public OrderDto() {
    }

    public String getName() {
        return name;
    }

    public OrderDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderDto setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public OrderDto setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
