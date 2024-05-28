package com.rockfly.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.AddItemInput;
import com.rockfly.models.Customers;
import com.rockfly.models.Price;
import com.rockfly.models.MainStock;
import com.rockfly.repositories.MainStockRepositories;
import com.rockfly.services.MainStockService;

@Service
public class MainStockServiceImpl implements MainStockService{

	@Autowired
	private MainStockRepositories mainStockRepositories;
	
	@Override
	public void saveItem(AddItemInput addItemInput) {
			
			MainStock shirtMainStock = new MainStock();
			shirtMainStock.setProductSpecification(addItemInput.getProductSpecification());
			shirtMainStock.setStyleNumber(addItemInput.getStyleNumber());
			shirtMainStock.setItemHsnSac(addItemInput.getItemHsnSac());
			shirtMainStock.setColor(addItemInput.getColor());
			shirtMainStock.setProductType(addItemInput.getProductType());
			shirtMainStock.setSize(addItemInput.getSize());
			shirtMainStock.setQuantity(addItemInput.getQuantity());
			
			
			Price price = new Price();
			price.setMrp(addItemInput.getMrp());
			price.setSalePrice(addItemInput.getSalePrice());
			price.setWholesalePrice(addItemInput.getWholesalePrice());
			price.setPurchasePrice(addItemInput.getPurchasePrice());
			price.setShirtMainStock(shirtMainStock);
			
			shirtMainStock.setPrice(price);
			
			mainStockRepositories.save(shirtMainStock);
		
	}

	/*
	 * @Override public List<MainStock> getMainStockSortByProductType(String
	 * productType) {
	 * 
	 * if (productType.equals("Jeans")) {
	 * 
	 * return mainStockRepositories.findByProductType(productType); }else if
	 * (productType.equals("Shirt")) {
	 * 
	 * return mainStockRepositories.findByProductType(productType);
	 * 
	 * }else if (productType.equals("T-Shirt")) { return
	 * mainStockRepositories.findByProductType(productType); }else if
	 * (productType.equals("Jacket")) { return
	 * mainStockRepositories.findByProductType(productType); }
	 * 
	 * return mainStockRepositories.findAll();
	 * 
	 * 
	 * }
	 */
	
	
	@Override
	public List<MainStockDTO> getMainStockSortByProductType(String productType) {
		
		if (productType.equals("All")) {
			
			  List<MainStock> mainStock = mainStockRepositories.findAll();
			  
			  return mainStock.stream() .map(this::fromEntityToDTO)
			  .collect(Collectors.toList());
			 
		}
			List<MainStock> mainStockByProductType = mainStockRepositories.findByProductType(productType);
			return mainStockByProductType.stream()
					.map(this::fromEntityToDTO)
					.collect(Collectors.toList());
			
	}
	
	
	public MainStockDTO fromEntityToDTO(MainStock mainStock) {
		return new MainStockDTO(mainStock.getId(), mainStock.getProductType(), mainStock.getStyleNumber(), mainStock.getItemHsnSac(),
				mainStock.getColor(), mainStock.getProductSpecification(), mainStock.getSize(), mainStock.getQuantity(),
				mainStock.getPrice());
	}


	

}
