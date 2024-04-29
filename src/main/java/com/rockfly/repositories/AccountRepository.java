package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
