package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.CategoryRepository;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
}
