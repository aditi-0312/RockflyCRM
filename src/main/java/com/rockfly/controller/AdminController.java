package com.rockfly.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.models.Account;
import com.rockfly.models.Customers;
import com.rockfly.services.AccountService;
import com.rockfly.services.CustomerServices;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerServices customerServices;

	@PostMapping("/addEmployee")
	public String register_accountString(@ModelAttribute Account account) {
		accountService.save(account);
		return "redirect:/";
	}

	@GetMapping("/addEmployee")
	public String getAddEmployeePage(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "pages/AddEmployee";

	}

	@GetMapping("/addItem")
	public String getAddItemPage() {
		return "pages/AddItem";
	}

	@GetMapping("/addCustomer")
	public String getAddCustomerPage(Model model) {
		Customers customers = new Customers();
		model.addAttribute("customers", customers);
		return "pages/AddCustomer";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute Customers customers) {
		System.out.println(customers.getName());
		customerServices.save(customers);
		return "redirect:/";

	}

//	@ResponseBody
//	@RequestMapping("/customers")
	// public List<CustomerDTO> getCustomerList() {

	// return customerServices.getAllCustomers();
	// }

	@GetMapping("/customers")
	public String getCustomerList(Model model,
			@RequestParam(required = false, name = "sort_by", defaultValue = "asOfDate") String sort_by,
			@RequestParam(required = false, name = "per_page", defaultValue = "1") String per_page,
			@RequestParam(required = false, name = "page", defaultValue = "1") String page) {
		// List<CustomerDTO> customerList = customerServices.getAllCustomers();

		Page<CustomerDTO> customers_on_page = customerServices.getAllCustomers(Integer.parseInt(page) - 1,
				Integer.parseInt(per_page), sort_by);
		int total_pages = customers_on_page.getTotalPages();
		List<Integer> pages = new ArrayList<>();
		if (total_pages > 0) {
			pages = IntStream.rangeClosed(0, total_pages - 1).boxed().collect(Collectors.toList());
		}

		List<String> links = new ArrayList<>();

		if (pages != null) {
			for (int link : pages) {
				String active = "";
				if (link == customers_on_page.getNumber()) {
					active = "active";
				}

				String _temp_link = "?per_page=" + per_page + "&page=" + (link + 1) + "&sort_by=" + sort_by;
				links.add("<li class=\"page-item " + active + "\"><a href=\"" + _temp_link + "\" class='page-link'>"
						+ (link + 1) + "</a></li>");
			}

			model.addAttribute("links", links);
		}

		model.addAttribute("customers", customers_on_page);
		return "pages/CustomerList";

	}
}
