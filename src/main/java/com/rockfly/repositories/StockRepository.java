package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}