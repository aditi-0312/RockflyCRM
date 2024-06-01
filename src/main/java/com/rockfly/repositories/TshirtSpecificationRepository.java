package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockfly.models.TshirtSpecifications;

public interface TshirtSpecificationRepository extends JpaRepository<TshirtSpecifications, Long> {

}
