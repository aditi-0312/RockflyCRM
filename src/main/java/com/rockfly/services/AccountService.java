package com.rockfly.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rockfly.models.Account;
import com.rockfly.models.Authority;
import com.rockfly.repositories.AccountRepository;
import com.rockfly.util.constants.Roles;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Account save(Account account) {

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		
//		account.setEmail(account.getEmail());
//		account.setName("admin");
//		account.setRole(Roles.ADMIN.getRole());
		
		
		if (account.getRole() == null) {
			account.setRole(Roles.BILLER.getRole());
		}
		return accountRepository.save(account);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Account> optionalAccount = accountRepository.findOneByEmailIgnoreCase(username);

		if (!optionalAccount.isPresent()) {
			throw new UsernameNotFoundException("Account not found");
		}
		Account account = optionalAccount.get();

		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		grantedAuthority.add(new SimpleGrantedAuthority(account.getRole()));
		
		for(Authority _auth: account.getAuthorities()){
            grantedAuthority.add(new SimpleGrantedAuthority(_auth.getName()));

}

		return new User(account.getEmail(), account.getPassword(), grantedAuthority);
	}
}
