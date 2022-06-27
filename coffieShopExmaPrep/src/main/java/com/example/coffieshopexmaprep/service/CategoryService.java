package com.example.coffieshopexmaprep.service;

import com.example.coffieshopexmaprep.entity.CategoryEntity;
import com.example.coffieshopexmaprep.entity.enums.CategoryEnum;
import com.example.coffieshopexmaprep.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories() {

        if(this.categoryRepository.count() != 0){
            return;
        }

        Arrays.stream(CategoryEnum.values()).forEach(c->
                {
                    CategoryEntity newCategory = new CategoryEntity();
                    newCategory.setName(c);
                    newCategory.setNeededTime(
                    switch (c){
                        case CAKE -> 10;
                        case DRINK -> 1;
                        case COFFEE -> 2;
                        case OTHER -> 5;
                    });

                    this.categoryRepository.save(newCategory);


                });


    }

    public CategoryEntity getByCategoryEnum(CategoryEnum category) {
        return this.categoryRepository.findByName(category);
    }
}
