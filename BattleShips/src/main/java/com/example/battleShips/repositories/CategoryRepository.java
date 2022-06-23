package com.example.battleShips.repositories;

import com.example.battleShips.entity.CategoryEntity;
import com.example.battleShips.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity,Long> {
}
