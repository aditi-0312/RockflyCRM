package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.ProductType;
import com.rockfly.repositories.ProductTypeRepository;
import com.rockfly.services.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Override
	public void addProductType(ProductType productType) {
		
		productTypeRepository.save(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		
		return productTypeRepository.findAll();
	}

}
