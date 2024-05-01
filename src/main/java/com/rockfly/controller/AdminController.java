package com.rockfly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/dashboard")
	public String getpage() {
		return "pages/dashboard";
	}
	
	@GetMapping("/addEmployee")
	public String getAddEmployeePage() {
		return "pages/AddEmployee";
	}
	
}
