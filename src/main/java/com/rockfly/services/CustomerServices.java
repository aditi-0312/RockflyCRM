package com.rockfly.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.models.Customers;
import com.rockfly.repositories.CustomersRepository;

@Service
public class CustomerServices {

	@Autowired
	private CustomersRepository customersRepository;

	public Customers save(Customers customers) {

		return customersRepository.save(customers);

	}

	public List<CustomerDTO> getAllCustomers() {
		List<Customers> customers = customersRepository.findAll();
		return customers.stream()
				.map(this::fromEntityToDTO)
				.collect(Collectors.toList());
	}

	public CustomerDTO fromEntityToDTO(Customers customers) {
		return new CustomerDTO(customers.getName(), customers.getOpeningBalance(), customers.getAsOfDate());
	}
}
