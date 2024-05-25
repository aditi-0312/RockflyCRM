package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.NumericSize;
import com.rockfly.repositories.NumericSizeRepository;
import com.rockfly.services.NumericSizeService;

@Service
public class NumericSizeServiceImpl implements NumericSizeService {

	@Autowired
	private NumericSizeRepository numericSizeRepository;
	
	@Override
	public void saveNumericSize(NumericSize numericSize) {
		numericSizeRepository.save(numericSize);
		
	}

	@Override
	public List<NumericSize> getAllNumericSize() {
		
		return numericSizeRepository.findAll();
	}

}
