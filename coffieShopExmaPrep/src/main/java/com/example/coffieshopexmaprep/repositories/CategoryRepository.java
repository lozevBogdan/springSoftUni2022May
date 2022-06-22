package com.example.coffieshopexmaprep.repositories;

import com.example.coffieshopexmaprep.entity.CategoryEntity;
import com.example.coffieshopexmaprep.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    CategoryEntity findByName(CategoryEnum category);
}
