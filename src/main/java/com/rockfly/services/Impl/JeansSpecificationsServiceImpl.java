package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.ProductSpecifications;
import com.rockfly.repositories.ProductSpecificationsRepository;
import com.rockfly.services.JeansSpecificationsService;

@Service
public class JeansSpecificationsServiceImpl implements JeansSpecificationsService {

	@Autowired
	private ProductSpecificationsRepository productSpecificationsRepository;
	
	@Override
	public void saveJeansSpecifications(ProductSpecifications productSpecifications) {
		productSpecificationsRepository.save(productSpecifications);
		
	}

	@Override
	public List<ProductSpecifications> getAllJeansSpecifications() {
		
		return productSpecificationsRepository.findAll();
	}

}
