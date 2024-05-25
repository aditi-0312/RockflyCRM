package com.rockfly.services.Impl;

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
import com.rockfly.services.AccountService;
import com.rockfly.util.constants.Roles;

@Service
public class AccountServiceImpl implements UserDetailsService, AccountService{

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Account save(Account account) {
		System.out.println(account.getPassword());
		System.out.println(account.getName());

		
		String encodedPassword=passwordEncoder.encode(account.getPassword());

		account.setPassword(encodedPassword);
		
		account.setEmail(account.getEmail());
		
		account.setName(account.getName());
		account.setAddress(account.getAddress());
		account.setAadhaar(account.getAadhaar());
		account.setCity(account.getCity());
		account.setPhone(account.getPhone());
		account.setPincode(account.getPincode());
		
		if(account.getRole()=="Admin")
		account.setRole(Roles.ADMIN.getRole());
		if(account.getRole()=="Sales")
			account.setRole(Roles.SALES.getRole());
		if(account.getRole()=="Dispatcher")
			account.setRole(Roles.DISPATCHER.getRole());
		if(account.getRole()=="Biller")
			account.setRole(Roles.BILLER.getRole());
		
	
		return accountRepository.save(account);
	}
	
	@Override
	 public boolean adminExists(String email) {
	        return accountRepository.findOneByEmailIgnoreCase(email).isPresent();
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
