package com.example.battleShips.service;

import com.example.battleShips.entity.CategoryEntity;
import com.example.battleShips.entity.enums.CategoryEnums;
import com.example.battleShips.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findCategoryByCategoryEnum(CategoryEnums category) {
        return this.categoryRepository.findByName(category);
    }
}
