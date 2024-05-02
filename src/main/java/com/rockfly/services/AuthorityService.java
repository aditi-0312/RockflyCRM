package com.rockfly.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.Authority;
import com.rockfly.repositories.AuthorityRepository;

@Service
public class AuthorityService {
	
	@Autowired AuthorityRepository authorityRepository;

	public Authority save(Authority authority) {
		return authorityRepository.save(authority);
	}
	
	 public Optional<Authority> findById(Long id){
	        return authorityRepository.findById(id);
	    }
}
