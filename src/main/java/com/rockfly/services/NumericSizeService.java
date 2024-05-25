package com.rockfly.services;

import java.util.List;

import com.rockfly.models.NumericSize;

public interface NumericSizeService {

	public void saveNumericSize(NumericSize numericSize);
	
	public List<NumericSize> getAllNumericSize();
}
