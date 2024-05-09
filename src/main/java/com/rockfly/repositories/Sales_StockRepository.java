package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Sales_Stock;

@Repository
public interface Sales_StockRepository extends JpaRepository<Sales_Stock, Long>{

}
