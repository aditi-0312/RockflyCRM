package com.rockfly.services;

import java.util.List;

import com.rockfly.dto.BarcodeDTO;
import com.rockfly.models.MainStock;
import com.rockfly.models.Price;
import com.rockfly.models.ProductType;

public interface ProductTypeService {
	
	public void addProductType(ProductType productType);
	
	public List<ProductType> getAllProductType();

	//BarcodeDTO fromEntityToDTO(MainStock mainStock, Price price);

	//List<BarcodeDTO> getProdutsForBarcode();
}
