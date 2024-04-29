package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Long>{

}
