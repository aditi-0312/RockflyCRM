package com.rockfly.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.repositories.ColorRepository;

@Service
public class ColorService {

	@Autowired
	private ColorRepository colorRepository;
}
