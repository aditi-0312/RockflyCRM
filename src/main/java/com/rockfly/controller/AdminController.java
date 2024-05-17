package com.rockfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.models.Account;
import com.rockfly.models.Customers;
import com.rockfly.models.LowerBody_MainStock;
import com.rockfly.services.AccountService;
import com.rockfly.services.CustomerServices;
import com.rockfly.services.MainStockService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private MainStockService mainStockService;
	
	@PostMapping("/addEmployee")
	public String register_accountString(@ModelAttribute Account account) {
		accountService.save(account);
		return "redirect:/";
	}
	
	@GetMapping("/addEmployee")
	public String getAddEmployeePage(Model model) {
		Account account=new Account();
		model.addAttribute("account", account);
		return "pages/AddEmployee";

	}
	
	//Add Item Page
	@GetMapping("/addItem")
	public String getAddItemPage() {
		return "pages/AddItem";
	}
	
	//Saving Item in database
	@PostMapping("/addItem")
	public String saveItem(@ModelAttribute LowerBody_MainStock lowerBody_MainStock) {
		
		mainStockService.saveLowerBodyMainStock(lowerBody_MainStock);
		return "redirect:/admin/addItem";
	}
	
	@GetMapping("/addCustomer")
	public String getAddCustomerPage(Model model) {
		Customers customers=new Customers();
		model.addAttribute("customers", customers);
		return "pages/AddCustomer";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute Customers customers) {
		System.out.println(customers.getName());
		customerServices.save(customers);
		return "redirect:/";
		
	}
	
	//@GetMapping("/customers")
	@ResponseBody
	@RequestMapping("/customers")
	public List<CustomerDTO> getCustomerList() {
		//return "pages/CustomerList";
		
		return customerServices.getAllCustomers();
	}
	
}
