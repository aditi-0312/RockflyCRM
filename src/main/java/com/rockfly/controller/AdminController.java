package com.rockfly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/dashboard")
	public String getDashboard() {
		return "Admin/AdminDashboard";
	}
	
	@GetMapping("/addEmployee")
	public String getAddEmployeePage() {
		return "Admin/AddEmployee";
	}
	
	@GetMapping("/test")
	public String gettest() {
		return "Admin/test";
	}
	
}
