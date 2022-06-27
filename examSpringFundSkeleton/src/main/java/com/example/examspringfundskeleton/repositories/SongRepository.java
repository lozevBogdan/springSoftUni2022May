package com.example.examspringfundskeleton.repositories;

import com.example.examspringfundskeleton.entity.SongEntity;
import com.example.examspringfundskeleton.entity.StyleEntity;
import com.example.examspringfundskeleton.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<SongEntity,Long> {





    Optional<Object> findByPerformer(String performer);
}
