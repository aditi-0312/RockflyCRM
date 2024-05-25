package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.AlphaNumericSize;
import com.rockfly.repositories.AlphaNumericSizeRepository;
import com.rockfly.services.AlphaNumericSizeService;

@Service
public class AlphaNumericServiceImpl implements AlphaNumericSizeService {

	@Autowired
	private AlphaNumericSizeRepository alphaNumericSizeRepository;
	
	@Override
	public void saveAlphaNumericSize(AlphaNumericSize alphaNumericSize) {
		alphaNumericSizeRepository.save(alphaNumericSize);
		
	}

	@Override
	public List<AlphaNumericSize> getAllAlphaNumericSize() {
		
		return alphaNumericSizeRepository.findAll();
	}
	
	

}
