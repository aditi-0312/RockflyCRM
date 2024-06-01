package com.rockfly.services;

import java.util.List;

import com.rockfly.models.TshirtSpecifications;

public interface TshirtSpecificationService {

	public void saveTshirtSpecificationService(TshirtSpecifications tshirtSpecifications);

	public List<TshirtSpecifications> getAllTshirtSpecifications();
}
