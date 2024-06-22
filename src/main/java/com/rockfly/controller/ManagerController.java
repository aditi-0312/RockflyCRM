package com.rockfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rockfly.models.ProductDetails;
import com.rockfly.models.RackNumber;
import com.rockfly.services.ProductDetailsService;
import com.rockfly.services.RackNumberService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private RackNumberService rackNumberService;
	
	//url mentioned in layout.html to navigate in main_stock_list page
	@GetMapping("/mainStock")
	public String getMainStockList(@RequestParam(name = "sortByproduct_type", defaultValue = "All") String product_type, Model model) {
		
	List<ProductDetails> mainStock = productDetailsService.getMainStockSortByProductType(product_type);
		
		model.addAttribute("MainStock" , mainStock);
		
		return "pages/manager/MainStockList";
	}
	
	//View Product Details When click on More button in main stock list page
	@GetMapping("/mainStock/{productId}")
	public String getProductDetails(@PathVariable("productId") Long id, Model model) {
			
		model.addAttribute("RackNumbers",rackNumberService.getAllRackNumbers());
		
		model.addAttribute("MainStockProduct", productDetailsService.getMainStockProductDetailById(id));
			
//		model.addAttribute("rackNumbers", mainStockService.getRackNumberByMainStockId(id));
			
		return "pages/manager/ViewProductDetails";
	}
	
	@PostMapping("/mainStock")
	public String saveRackNumber(@RequestParam(name = "mainStockId") Long id, @ModelAttribute RackNumber rackNumber) {
		
//			mainStockService.setRackNumber(id, rackNumber);
			Long productId = id;
		return "redirect:/mainStock/" + productId;
	}
}
