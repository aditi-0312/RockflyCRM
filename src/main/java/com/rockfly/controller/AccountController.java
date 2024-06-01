package com.rockfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.MainStock;
import com.rockfly.models.RackNumber;
import com.rockfly.services.MainStockService;
import com.rockfly.services.RackNumberService;

@Controller
public class AccountController {
	
	@Autowired
	private MainStockService mainStockService;
	
	@Autowired
	private RackNumberService rackNumberService;

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
	
	//View Product Details When click on More button
	@GetMapping("/mainStock/{productId}")
	public String getProductDetails(@PathVariable("productId") Long id, Model model) {
		
		model.addAttribute("RackNumbers",rackNumberService.getAllRackNumbers());
		
		model.addAttribute("MainStockProduct", mainStockService.getMainStockProductDetailById(id));
		
		model.addAttribute("rackNumbers", mainStockService.getRackNumberByMainStockId(id));
		
		return "pages/ViewProductDetails";
	}
	
	@PostMapping("/mainStock")
	public String saveRackNumber(@RequestParam(name = "mainStockId") Long id, @ModelAttribute RackNumber rackNumber) {
		
			mainStockService.setRackNumber(id, rackNumber);
			Long productId = id;
		return "redirect:/mainStock/" + productId;
	}
	
	@GetMapping("/salesStock")
	public String getSalesStockList() {
		return "pages/SalesStockList";
	}
	
}
