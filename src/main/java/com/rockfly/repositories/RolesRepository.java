package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockfly.models.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

	Roles findByRole(String role);
}
