package com.example.examspringfundskeleton.service;

import com.example.examspringfundskeleton.entity.CategoryEntity;
import com.example.examspringfundskeleton.entity.CategoryNameEnum;
import com.example.examspringfundskeleton.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

   private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findCategoryByCategoryEnum(CategoryNameEnum category) {

        return this.categoryRepository.findByName(category).get();
    }
}
