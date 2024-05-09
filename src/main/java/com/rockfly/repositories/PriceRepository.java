package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
