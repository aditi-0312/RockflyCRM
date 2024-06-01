package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.TshirtSpecifications;
import com.rockfly.repositories.TshirtSpecificationRepository;
import com.rockfly.services.TshirtSpecificationService;

@Service
public class TshirtSpecificationServiceImpl implements TshirtSpecificationService {

	@Autowired
	private TshirtSpecificationRepository tshirtSpecificationRepository;
	
	@Override
	public void saveTshirtSpecificationService(TshirtSpecifications tshirtSpecifications) {
		tshirtSpecificationRepository.save(tshirtSpecifications);
		
	}
	
	@Override
	public List<TshirtSpecifications> getAllTshirtSpecifications() {
		return tshirtSpecificationRepository.findAll();
		
	}

}
