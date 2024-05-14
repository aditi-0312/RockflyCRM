package com.rockfly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

	@GetMapping("/dashboard")
	public String getpage() {
		return "pages/dashboard";
	}
	
	@GetMapping("/mainStock")
	public String getMainStockList() {
		return "pages/MainStockList";
	}	
	
	@GetMapping("/salesStock")
	public String getSalesStockList() {
		return "pages/SalesStockList";
	}
	
}
