package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.SalesRepository;
import com.rockfly.repositories.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;

}
