package com.example.examspringfundskeleton.service;

import com.example.examspringfundskeleton.dtos.ProductAddDto;
import com.example.examspringfundskeleton.entity.CategoryEntity;
import com.example.examspringfundskeleton.entity.ProductEntity;
import com.example.examspringfundskeleton.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;


    public ProductService(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public ProductEntity addInDb(ProductAddDto productAddDto) {

        ProductEntity newProduct = this.modelMapper.map(productAddDto,ProductEntity.class);

        CategoryEntity category =
                this.categoryService.findCategoryByCategoryEnum(productAddDto.getCategory());

        newProduct.setCategory(category);

        return this.productRepository.save(newProduct);
    }

    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }

    public void buyProductWithId(Long id) {
       this.productRepository.deleteById(id);
    }

    public void buyAllProducts() {
        this.productRepository.deleteAll();
    }
}
