package com.rockfly.services;

import java.util.Optional;

import com.rockfly.models.Authority;

public interface AuthorityService {

	Authority save(Authority authority);

	Optional<Authority> findById(Long id);

}
