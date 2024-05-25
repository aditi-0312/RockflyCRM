package com.rockfly.services;

import java.util.List;

import com.rockfly.models.AlphaNumericSize;

public interface AlphaNumericSizeService {

	public void saveAlphaNumericSize(AlphaNumericSize alphaNumericSize);
	
	public List<AlphaNumericSize> getAllAlphaNumericSize();
}
