package com.example.battleShips.repositories;

import com.example.battleShips.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<UserEntity,Long> {
}
