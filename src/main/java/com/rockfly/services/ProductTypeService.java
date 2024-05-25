package com.rockfly.services;

import java.util.List;

import com.rockfly.models.ProductType;

public interface ProductTypeService {
	
	public void addProductType(ProductType productType);
	
	public List<ProductType> getAllProductType();
}
