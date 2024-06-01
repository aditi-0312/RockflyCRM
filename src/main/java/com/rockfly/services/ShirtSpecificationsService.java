package com.rockfly.services;

import java.util.List;

import com.rockfly.models.ShirtSpecifications;

public interface ShirtSpecificationsService {

	public void saveShirtSpecifications(ShirtSpecifications shirtSpecifications);
	
	public List<ShirtSpecifications> getAllShirtSpecifications();
}
