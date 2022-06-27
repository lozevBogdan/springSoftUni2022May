package com.example.examspringfundskeleton.dtos;

import com.example.examspringfundskeleton.entity.CategoryEntity;
import com.example.examspringfundskeleton.entity.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddDto {


    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Size(min = 5)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent
    private LocalDateTime neededBefore;

    @NotNull
    private CategoryNameEnum category;

    public String getName() {
        return name;
    }

    public ProductAddDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddDto setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductAddDto setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "ProductAddDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", neededBefore=" + neededBefore +
                ", category=" + category +
                '}';
    }
}
