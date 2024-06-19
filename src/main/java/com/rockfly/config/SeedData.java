package com.rockfly.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rockfly.models.Account;
import com.rockfly.models.Authority;
import com.rockfly.repositories.RolesRepository;
import com.rockfly.services.Impl.AccountServiceImpl;
import com.rockfly.services.Impl.AuthorityServiceImpl;
import com.rockfly.models.Roles ;

@Component
public class SeedData implements CommandLineRunner{
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@Autowired
	private AuthorityServiceImpl authorityService;
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		// Check if admin account already exists
        if (!accountService.adminExists("admin@rockfly.com")) {
            Account account1 = new Account();
            account1.setEmail("admin@rockfly.com");
            account1.setPassword("123");
            account1.setName("admin");
            
            Roles role =  rolesRepository.findByRole("ADMIN");
            
            account1.addRole(role);
            accountService.saveAccountByDefaultRole(account1);
        }

	}

}
