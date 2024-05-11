package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.CustomersRepository;

@Service
public class CustomerServices {

	@Autowired
	private CustomersRepository customersRepository;
}
