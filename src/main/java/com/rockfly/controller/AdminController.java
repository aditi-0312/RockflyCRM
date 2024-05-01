package com.rockfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rockfly.models.Account;
import com.rockfly.services.AccountService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/dashboard")
	public String getpage() {
		return "pages/dashboard";
	}
	
	
	@PostMapping("/addEmployee")
	public String register_accountString(@ModelAttribute Account account) {
		accountService.save(account);
		return "redirect:/";
	}
	
	@GetMapping("/addEmployee")
	public String getAddEmployeePage() {
		return "pages/AddEmployee";

	}
	
}
