package com.example.examspringfundskeleton.repositories;

import com.example.examspringfundskeleton.entity.SongEntity;
import com.example.examspringfundskeleton.entity.StyleEntity;
import com.example.examspringfundskeleton.entity.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity,Long> {


    Optional<StyleEntity> findByName(StyleEnum name);



}

