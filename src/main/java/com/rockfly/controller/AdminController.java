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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rockfly.dto.BarcodeDTO;
import com.rockfly.dto.CustomerDTO;
import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.Account;
import com.rockfly.models.AddItemInput;
import com.rockfly.models.AlphaNumericSize;
import com.rockfly.models.Customers;

import com.rockfly.models.JeansSpecifications;
import com.rockfly.models.NumericSize;
import com.rockfly.models.ProductType;
import com.rockfly.models.RackNumber;
import com.rockfly.models.ShirtSpecifications;
import com.rockfly.models.TshirtSpecifications;

import com.rockfly.models.DocumentType;
import com.rockfly.models.NumericSize;
import com.rockfly.models.ProductType;
import com.rockfly.repositories.CustomersRepository;
import com.rockfly.repositories.DocumentTypeRepository;
import com.rockfly.services.AlphaNumericSizeService;
import com.rockfly.services.CustomerService;
import com.rockfly.services.JeansSpecificationsService;
import com.rockfly.services.MainStockService;
import com.rockfly.services.NumericSizeService;
import com.rockfly.services.ProductTypeService;
import com.rockfly.services.RackNumberService;
import com.rockfly.services.ShirtSpecificationsService;
import com.rockfly.services.TshirtSpecificationService;
import com.rockfly.services.Impl.AccountServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AccountServiceImpl accountService;

	@Autowired
	private CustomerService customerServices;

	@Autowired
	private ProductTypeService productTypeService;

	@Autowired
	private NumericSizeService numericSizeService;

	@Autowired
	private AlphaNumericSizeService alphaNumericSizeService;

	@Autowired
	private MainStockService mainStockService;
	
	@Autowired

	private RackNumberService rackNumberService;
	
	@Autowired
	private TshirtSpecificationService tshirtSpecificationService;
	
	@Autowired
	private ShirtSpecificationsService shirtSpecificationsService;
	
	@Autowired
	private JeansSpecificationsService jeansSpecificationsService;

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Autowired
	private CustomersRepository customersRepository;


	@GetMapping("/addEmployee")
	public String getAddEmployeePage(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "pages/AddEmployee";

	}
	
	@PostMapping("/addEmployee")
	public String register_accountString(@ModelAttribute Account account,RedirectAttributes attributes) {
		try {
			accountService.save(account);
			attributes.addFlashAttribute("message","Employee added successfully");
			return "redirect:/admin/addEmployee";
			
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/admin/addEmployee";

		}
		
	}

	// Add Item Page

	@GetMapping("/addItem")
	public String getAddItemPage(Model model) {

		model.addAttribute("productType", productTypeService.getAllProductType());
		
		model.addAttribute("numericSize", numericSizeService.getAllNumericSize());

		model.addAttribute("AlphanumericSize", alphaNumericSizeService.getAllAlphaNumericSize());
		
		model.addAttribute("tshirtSpecifications", tshirtSpecificationService.getAllTshirtSpecifications());
		
		model.addAttribute("shirtSpecifications", shirtSpecificationsService.getAllShirtSpecifications());
		return "pages/AddItem";
	}

	// Saving Item in database
	@PostMapping("/addItem")
	public String saveItem(@ModelAttribute AddItemInput addItemInput) {

		mainStockService.saveItem(addItemInput);

		return "redirect:/admin/addItem";
	}

	// ADD/List of Product/Size
	@GetMapping("/addProductAndSize")
	public String AddproductAndSizePage(Model model) {

		model.addAttribute("productType", productTypeService.getAllProductType());

		model.addAttribute("numericSize", numericSizeService.getAllNumericSize());

		model.addAttribute("AlphanumericSize", alphaNumericSizeService.getAllAlphaNumericSize());

		return "pages/AddProductAndSize";
	}

	// Add Product
	@PostMapping("/addProductAndSize")
	public String AddProductType(@ModelAttribute ProductType productType) {

		productTypeService.addProductType(productType);
	
		return "redirect:/admin/addProductAndSize";
	}
	
	//Specifications And Rack Number
	@GetMapping("/addSpecificationsAndRackNumber")
	public String AddSpecificationsAndRackNumber(Model model) {
		
		model.addAttribute("RackNumbers",rackNumberService.getAllRackNumbers());
		
		model.addAttribute("tshirtSpecifications", tshirtSpecificationService.getAllTshirtSpecifications());
		
		model.addAttribute("shirtSpecifications", shirtSpecificationsService.getAllShirtSpecifications());
		
		return "pages/AddSpecificationsAndRackNumber";
	}
	
	//saving T-shirt SpecificationService
	@PostMapping("/saveTshirtSpecificationRepository")
	public String savetshirtSpecificationRepository(@ModelAttribute TshirtSpecifications tshirtSpecifications) {
		
		tshirtSpecificationService.saveTshirtSpecificationService(tshirtSpecifications);
		return "redirect:/admin/addSpecificationsAndRackNumber";
	}
	
	//Saving Shirt Specifications
	@PostMapping("/saveShirtSpecification")
	public String saveShirtSpecifications(@ModelAttribute ShirtSpecifications shirtSpecifications) {
		shirtSpecificationsService.saveShirtSpecifications(shirtSpecifications);
		return "redirect:/admin/addSpecificationsAndRackNumber";
	}
	
	//saving Jeans Specifications 
	public String saveJeansSpecifications(@ModelAttribute JeansSpecifications jeansSpecifications) {
		
		jeansSpecificationsService.saveJeansSpecifications(jeansSpecifications);
		
		return "redirect:/admin/addSpecificationsAndRackNumber";
	}
	//saving Rank Number
	@PostMapping("/saveRackNumber")
	public String saveRackNumber(@ModelAttribute RackNumber rackNumber) {
		rackNumberService.saveRack(rackNumber);
		return "redirect:/admin/addSpecificationsAndRackNumber";
	}

	
	  // Add Numeric Size
	  @PostMapping("/addNumericSize")
	  public String AddNumericSize(@ModelAttribute NumericSize numericSize) {
	  
	  numericSizeService.saveNumericSize(numericSize); 
	  return "redirect:/admin/addProductAndSize"; }
	  
	  // Add Alpha-Numeric Size 
	  @PostMapping("/addAlphaNumericSize") 
	  public String AddNumericSize(@ModelAttribute AlphaNumericSize alphaNumericSize) {
	  
	  alphaNumericSizeService.saveAlphaNumericSize(alphaNumericSize); 
	  return "redirect:/admin/addProductAndSize"; 
	  }
	 

	@GetMapping("/addCustomer")
	public String getAddCustomerPage(Model model) {
		Customers customers = new Customers();
		model.addAttribute("customers", customers);
		
		List<DocumentType> docs=new ArrayList<>();
		docs.addAll(documentTypeRepository.findAll());
		model.addAttribute("docs", docs);
		DocumentType documentType=new DocumentType();
		model.addAttribute("docType",documentType);
		return "pages/AddCustomer";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute Customers customers,RedirectAttributes attributes) {
		System.out.println(customers.getShopName());
		try {
			customerServices.save(customers);
			attributes.addFlashAttribute("message","Customer added successfully");
			return "redirect:/admin/addCustomer";
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/admin/addCustomer";
		}
	
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
	
	//display customers having specific id from the search bar
	@GetMapping("/customer/{id}")
	public String getCustomer(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("customer", customersRepository.findById(id).get());
		return "pages/Customer";
	}

	@PostMapping("/documentType")
	public String manageDocumentType(@ModelAttribute DocumentType docType) {
		documentTypeRepository.save(docType);
		return "redirect:/admin/addCustomer";
	}

	// to get barcode of each item added
//	@GetMapping("/product")
//	public String product(Model model) {
//
//		//List<BarcodeDTO> products = productTypeService;
//
//	//	model.addAttribute("MainStock", mainStock);
//		return "pages/ProductList";
//	}
	
}
