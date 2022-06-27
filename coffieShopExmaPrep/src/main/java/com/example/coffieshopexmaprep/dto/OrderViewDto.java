package com.example.coffieshopexmaprep.dto;

import com.example.coffieshopexmaprep.entity.CategoryEntity;
import com.example.coffieshopexmaprep.entity.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderViewDto {


    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryEntity category;

    public OrderViewDto() {
    }

    public Long getId() {
        return id;
    }

    public OrderViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderViewDto setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }
}
