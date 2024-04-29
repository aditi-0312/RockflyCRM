package com.rockfly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rockfly.models.Account;
import com.rockfly.models.Sales;
import com.rockfly.services.AccountService;

@Component
public class SeedData implements CommandLineRunner{
	
	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		
		
		Account account1 = new Account();
		Account account2 = new Account();
		
		account1.setEmail("admin@rockfly.com");
		account1.setPassword("123");
		account1.setName("admin");
		
		account2.setEmail("user@rockfly.com");
		account2.setPassword("123");
		account2.setName("user");
		
		accountService.save(account1);
		accountService.save(account2);
		
	}

}
