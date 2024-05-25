package com.rockfly.services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.Authority;
import com.rockfly.repositories.AuthorityRepository;
import com.rockfly.services.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired AuthorityRepository authorityRepository;

	@Override
	public Authority save(Authority authority) {
		return authorityRepository.save(authority);
	}
	
	@Override
	 public Optional<Authority> findById(Long id){
	        return authorityRepository.findById(id);
	    }
}
