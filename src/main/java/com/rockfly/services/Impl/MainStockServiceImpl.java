package com.rockfly.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.AddItemInput;
import com.rockfly.models.Customers;
import com.rockfly.models.RackNumber;
import com.rockfly.models.MainStock;

import com.rockfly.repositories.RackNumberRepository;

import com.rockfly.repositories.MainStockRepository;

import com.rockfly.services.MainStockService;

@Service
public class MainStockServiceImpl implements MainStockService{

	@Autowired
	private MainStockRepository mainStockRepositories;
	
	@Autowired
	private RackNumberRepository rackNumberRepository;
	
	@Override
	public void saveItem(MainStock mainStock) {
			
		mainStockRepositories.save(mainStock);
		
	}	
	
	@Override
	public List<MainStock> getMainStockSortByProductType(String productType) {
		
		return mainStockRepositories.findAll();
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
