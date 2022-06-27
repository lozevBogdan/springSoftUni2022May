package com.example.examspringfundskeleton.repositories;

import com.example.examspringfundskeleton.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {



}
