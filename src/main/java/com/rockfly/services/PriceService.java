package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
}
