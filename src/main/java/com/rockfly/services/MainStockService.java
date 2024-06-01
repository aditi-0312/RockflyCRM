package com.rockfly.services;

import java.util.List;

import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.AddItemInput;
import com.rockfly.models.MainStock;
import com.rockfly.models.RackNumber;

import lombok.val;

public interface MainStockService {
	
	public void saveItem(AddItemInput addItemInput);
	
	public List<MainStockDTO> getMainStockSortByProductType(String productType);
	
	public MainStock getMainStockProductDetailById(Long id);
	
	public void setRackNumber(Long id, RackNumber rackNumber);
	
	public List<RackNumber> getRackNumberByMainStockId(Long id);

}
