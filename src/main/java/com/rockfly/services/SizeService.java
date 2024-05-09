package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.SalesRepository;
import com.rockfly.repositories.SizeRepository;

@Service
public class SizeService {
	
	@Autowired
	 private SizeRepository sizeRepository;

}
