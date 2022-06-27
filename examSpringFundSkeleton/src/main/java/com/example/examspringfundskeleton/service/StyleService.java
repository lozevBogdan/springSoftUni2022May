package com.example.examspringfundskeleton.service;

import com.example.examspringfundskeleton.entity.StyleEntity;
import com.example.examspringfundskeleton.entity.StyleEnum;
import com.example.examspringfundskeleton.repositories.StyleRepository;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }


    public StyleEntity findStyleByStyleEnum(StyleEnum style) {
        return this.styleRepository.findByName(style).get();
    }


}
