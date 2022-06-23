package com.example.battleShips.repositories;

import com.example.battleShips.entity.ShipEntity;
import com.example.battleShips.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {

    Optional<ShipEntity> findByName(String name);
}

