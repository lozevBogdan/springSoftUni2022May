package com.example.battleShips.init;

import com.example.battleShips.entity.CategoryEntity;
import com.example.battleShips.entity.enums.CategoryEnums;
import com.example.battleShips.repositories.CategoryRepository;
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

        if (categoryRepository.count() == 0){
            Arrays.stream(CategoryEnums.values()).
                    forEach(c->{

                        CategoryEntity category =new CategoryEntity();
                        category.setName(c).
                                setDescription(c.name());

                        this.categoryRepository.save(category);

                    });

        }

    }
}
