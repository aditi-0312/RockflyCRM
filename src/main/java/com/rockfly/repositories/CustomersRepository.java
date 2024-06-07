package com.rockfly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long>{

	//search
	public List<Customers> findByShopNameContaining(String keywords);
}
