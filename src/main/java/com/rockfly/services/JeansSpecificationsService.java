package com.rockfly.services;

import java.util.List;

import com.rockfly.models.ProductSpecifications;

public interface JeansSpecificationsService {

	public void saveJeansSpecifications(ProductSpecifications productSpecifications);
	
	public List<ProductSpecifications> getAllJeansSpecifications();
}
