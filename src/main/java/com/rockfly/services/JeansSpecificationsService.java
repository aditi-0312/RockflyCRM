package com.rockfly.services;

import java.util.List;

import com.rockfly.models.JeansSpecifications;

public interface JeansSpecificationsService {

	public void saveJeansSpecifications(JeansSpecifications jeansSpecifications);
	
	public List<JeansSpecifications> getAllJeansSpecifications();
}
