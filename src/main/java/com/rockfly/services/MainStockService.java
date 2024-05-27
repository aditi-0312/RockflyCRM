package com.rockfly.services;

import java.util.List;

import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.AddItemInput;
import com.rockfly.models.MainStock;

public interface MainStockService {
	
	public void saveItem(AddItemInput addItemInput);
	
	public List<MainStockDTO> getMainStockSortByProductType(String productType);
	
	

}
