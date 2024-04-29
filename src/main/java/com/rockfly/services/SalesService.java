package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	SalesRepository salesRepository;

}
