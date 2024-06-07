package com.rockfly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockfly.models.MainStock;

public interface MainStockRepository extends JpaRepository<MainStock, Long>{

//	List<MainStock> findByProductType(String productType);
}
