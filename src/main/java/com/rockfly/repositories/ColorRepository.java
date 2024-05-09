package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}
