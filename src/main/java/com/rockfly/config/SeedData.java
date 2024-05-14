package com.rockfly.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rockfly.models.Account;
import com.rockfly.models.Authority;
import com.rockfly.services.AccountService;
import com.rockfly.services.AuthorityService;
import com.rockfly.util.constants.Privileges;
import com.rockfly.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner{
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AuthorityService authorityService;

	@Override
	public void run(String... args) throws Exception {
		
		for (Privileges priv : Privileges.values()) {
            Authority authority = new Authority();
            authority.setId(priv.getId());
            authority.setName(priv.getPrivilege());
            authorityService.save(authority);
        }
		
		//Account account1 = new Account();
//		Account account2 = new Account();
//		Account account3=new Account();
//		Account account4=new Account();
//		
		// Check if admin account already exists
        if (!accountService.adminExists("admin@rockfly.com")) {
            Account account1 = new Account();
            account1.setEmail("admin@rockfly.com");
            account1.setPassword("123");
            account1.setName("admin");
            account1.setRole(Roles.ADMIN.getRole());
            accountService.save(account1);
        }
//		
//		account2.setEmail("sales@rockfly.com");
//		account2.setPassword("123");
//		account2.setName("salesman");
//		account2.setRole(Roles.SALES.getRole());
//		
//		Set<Authority> authorities = new HashSet<>();
//        authorityService.findById(Privileges.ACCESS_SALES_TABLE.getId()).ifPresent(authorities::add);
//        account2.setAuthorities(authorities);
//		
//		account3.setEmail("biller@rockfly.com");
//		account3.setPassword("123");
//		account3.setName("biller");
//		
//		account4.setEmail("dispatcher@rockfly.com");
//		account4.setPassword("123");
//		account4.setName("dispatcher");
//		account4.setRole(Roles.DISPATCHER.getRole());
//		Set<Authority> authorities2 = new HashSet<>();
//        authorityService.findById(Privileges.ACCESS_DISPATCHER_TABLE.getId()).ifPresent(authorities2::add);
//        authorityService.findById(Privileges.ACCESS_MAIN_INVENTORY.getId()).ifPresent(authorities2::add);
//        authorityService.findById(Privileges.ACCESS_SALES_TABLE.getId()).ifPresent(authorities2::add);
//        account4.setAuthorities(authorities2);
//		
		
//		accountService.save(account2);
//		accountService.save(account3);
//		accountService.save(account4);
	}

}
