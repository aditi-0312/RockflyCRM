package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.SalesRepository;
import com.rockfly.repositories.Sales_StockRepository;

@Service
public class Sales_StockService {
	
	@Autowired
	private Sales_StockRepository sales_StockRepository;

}
