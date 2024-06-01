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
import com.rockfly.models.RackNumber;
import com.rockfly.models.MainStock;
import com.rockfly.repositories.MainStockRepositories;
import com.rockfly.repositories.RackNumberRepository;
import com.rockfly.services.MainStockService;

@Service
public class MainStockServiceImpl implements MainStockService{

	@Autowired
	private MainStockRepositories mainStockRepositories;
	
	@Autowired
	private RackNumberRepository rackNumberRepository;
	
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

	@Override
	public MainStock getMainStockProductDetailById(Long id) {
		MainStock mainStockProductDetail = mainStockRepositories.findById(id).get();
		return mainStockProductDetail;
	}


	@Override
	public void setRackNumber(Long id, RackNumber rackNumber) {
		MainStock mainStock = getMainStockProductDetailById(id);
		
		RackNumber rackNumber2  = rackNumberRepository.findById(rackNumber.getId()).get();
		
		List<RackNumber> rack = mainStock.getRackNumber();
		rack.add(rackNumber2);
		
		List<MainStock> mainStocks = rackNumber2.getMainStock();
		mainStocks.add(mainStock);
		mainStockRepositories.save(mainStock);
	}


	@Override
	public List<RackNumber> getRackNumberByMainStockId(Long id) {
		MainStock mainStock = getMainStockProductDetailById(id);
		
		List<RackNumber> rackNumbers = mainStock.getRackNumber();		
		return rackNumbers;
	}


	

}
