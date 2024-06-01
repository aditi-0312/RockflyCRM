package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.JeansSpecifications;
import com.rockfly.repositories.JeansSpecificationsRepository;
import com.rockfly.services.JeansSpecificationsService;

@Service
public class JeansSpecificationsServiceImpl implements JeansSpecificationsService {

	@Autowired
	private JeansSpecificationsRepository jeansSpecificationsRepository;
	
	@Override
	public void saveJeansSpecifications(JeansSpecifications jeansSpecifications) {
		jeansSpecificationsRepository.save(jeansSpecifications);
		
	}

	@Override
	public List<JeansSpecifications> getAllJeansSpecifications() {
		
		return jeansSpecificationsRepository.findAll();
	}

}
