package com.rockfly.services;

import com.rockfly.models.Account;

public interface AccountService {

	Account save(Account account);
	boolean adminExists(String email);

}
