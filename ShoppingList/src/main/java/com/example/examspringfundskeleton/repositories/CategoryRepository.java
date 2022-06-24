package com.example.examspringfundskeleton.repositories;

import com.example.examspringfundskeleton.entity.CategoryEntity;
import com.example.examspringfundskeleton.entity.CategoryNameEnum;
import com.example.examspringfundskeleton.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {


    Optional<CategoryEntity> findByName(CategoryNameEnum name);


}
