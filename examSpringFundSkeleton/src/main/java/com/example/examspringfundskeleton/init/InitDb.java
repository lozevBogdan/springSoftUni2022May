package com.example.examspringfundskeleton.init;

import com.example.examspringfundskeleton.entity.StyleEntity;
import com.example.examspringfundskeleton.entity.StyleEnum;
import com.example.examspringfundskeleton.repositories.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitDb implements CommandLineRunner {

    private final StyleRepository styleRepository;

    public InitDb(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(this.styleRepository.count() == 0){
            Arrays.stream(StyleEnum.values()).forEach(c->{
                StyleEntity style = new StyleEntity();
                style.setName(c).setDescription(c.name());

                this.styleRepository.save(style);
            });
        }

    }
}
