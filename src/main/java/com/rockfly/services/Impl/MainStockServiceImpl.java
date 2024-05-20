package com.rockfly.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.LowerBody_MainStock;
import com.rockfly.models.Price;
import com.rockfly.repositories.LowerBody_MainStockRepository;
import com.rockfly.services.MainStockService;

@Service
public class MainStockServiceImpl implements MainStockService {

	@Autowired
	private LowerBody_MainStockRepository lowerBody_MainStockRepository;
	
	@Override
	public LowerBody_MainStock saveLowerBodyMainStock(LowerBody_MainStock lowerBody_MainStock) {
		
//		Price price = lowerBody_MainStock.getPrice();
//		
//		Price savePrice = new Price();
//		
//		savePrice.setMrp(price.getMrp());
//		savePrice.setPurchase_price(price.getPurchase_price());
//		savePrice.setLowerBody_MainStock(lowerBody_MainStock);
//		
//		
//		lowerBody_MainStock.setPrice(savePrice);
		
		
		return lowerBody_MainStockRepository.save(lowerBody_MainStock);
	}

}
