package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.ShirtSpecifications;
import com.rockfly.repositories.ShirtSpecificationsRepository;
import com.rockfly.services.ShirtSpecificationsService;

@Service
public class ShirtSpecificationsServiceImpl implements ShirtSpecificationsService {

	@Autowired
	private ShirtSpecificationsRepository shirtSpecificationsRepository;
	
	@Override
	public void saveShirtSpecifications(ShirtSpecifications shirtSpecifications) {
		shirtSpecificationsRepository.save(shirtSpecifications);
		
	}

	@Override
	public List<ShirtSpecifications> getAllShirtSpecifications() {
		
		return shirtSpecificationsRepository.findAll();
	}

}