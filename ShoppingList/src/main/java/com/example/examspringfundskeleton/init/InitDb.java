package com.example.examspringfundskeleton.init;

import com.example.examspringfundskeleton.entity.CategoryEntity;
import com.example.examspringfundskeleton.entity.CategoryNameEnum;
import com.example.examspringfundskeleton.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitDb implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public InitDb(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count() == 0){

            Arrays.stream(CategoryNameEnum.values()).forEach(c->{

                CategoryEntity category = new CategoryEntity();
                category.
                        setName(c).
                        setDescription(c.name().toString());

                this.categoryRepository.save(category);

            });
        }

    }
}
