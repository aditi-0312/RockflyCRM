package com.rockfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.MainStock;
import com.rockfly.services.MainStockService;

@Controller
public class AccountController {
	
	@Autowired
	private MainStockService mainStockService;

	@GetMapping("/dashboard")
	public String getpage() {
		return "pages/dashboard";
	}
	
	@GetMapping("/mainStock")
	public String getMainStockList(@RequestParam(name = "sortByproduct_type", defaultValue = "All") String product_type, Model model) {
		
	List<MainStockDTO> mainStock = mainStockService.getMainStockSortByProductType(product_type);
		
		model.addAttribute("MainStock" , mainStock);
		
		return "pages/MainStockList";
	}	
	
	@GetMapping("/salesStock")
	public String getSalesStockList() {
		return "pages/SalesStockList";
	}
	
}
