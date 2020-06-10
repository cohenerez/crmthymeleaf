package com.erez.thymeleaf.crmthymeleaf.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erez.thymeleaf.crmthymeleaf.entity.Address;
import com.erez.thymeleaf.crmthymeleaf.entity.Customer;
import com.erez.thymeleaf.crmthymeleaf.entity.SalesRepresentative;
import com.erez.thymeleaf.crmthymeleaf.service.CityService;
import com.erez.thymeleaf.crmthymeleaf.service.CountryService;
import com.erez.thymeleaf.crmthymeleaf.service.CustomerService;
import com.erez.thymeleaf.crmthymeleaf.service.SalesRepresentativeService;
import com.erez.thymeleaf.crmthymeleaf.service.StateService;
import com.google.gson.Gson;




@Controller
@RequestMapping("/customers")
public class CustomrController {

	private CustomerService customerService;
	private SalesRepresentativeService salesRepresentativeService;
	private List<SalesRepresentative> theSalesRepresentatives;
	private CountryService countryService;
	private StateService stateService;
	private CityService cityService;
	private String counttryName;
	private String stateName;

	@Autowired
	public CustomrController(CustomerService theCustomerService,
			SalesRepresentativeService theSalesRepresentativeService, 
			CountryService theCountryService,StateService theStateService,
			CityService theCityService) {

		customerService = theCustomerService;
		salesRepresentativeService = theSalesRepresentativeService;
        countryService = theCountryService;
        stateService = theStateService;
        cityService = theCityService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@GetMapping("/showFormForAddCustomer")
	public String showFormForAddCustomer(Model theModel ) {

		Customer theCustomer = new Customer();
		SalesRepresentative salesRepresentative = new SalesRepresentative();
		Address address = new 	Address();	
		theCustomer.setAddress(address);
		theCustomer.setSalesRepresentative(salesRepresentative);
		theSalesRepresentatives = salesRepresentativeService.getSalesRepresentatives();

		theModel.addAttribute("customer", theCustomer);
		theModel.addAttribute("salesRepresentatives", theSalesRepresentatives);
		theModel.addAttribute("countries", countryService.findAll());
				
		return "customers/customer-form";
	}


	

	@GetMapping("/list")
	public String listCustomrs(Model theModel ,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(6);

		Page<Customer> customerPage = customerService.getAllCustomersPaginated(PageRequest.of(currentPage - 1, pageSize));

		int totalPages = customerPage.getTotalPages();


		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			theModel.addAttribute("pageNumbers", pageNumbers);
		}

		theModel.addAttribute("customerPage", customerPage);


		return "customers/list-customers";
	}



	@GetMapping("/search")
	public String searchCustomerByName(@RequestParam("customerName") String theName, Model theModel,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(2);

		Page<Customer> customerPage = 
				customerService.searchCustomerByName(theName, PageRequest.of(currentPage - 1, pageSize));

		int totalPages = customerPage.getTotalPages();

		if (totalPages > 0) {
			List<Integer> pageNumbers = 
					IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			theModel.addAttribute("pageNumbers", pageNumbers);
		}

		theModel.addAttribute("customerPage", customerPage);

		return "customers/list-customers";

	}


	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer")  @Valid Customer theCustomer ,
			BindingResult bindingResult ,Model theModel) {

		if (bindingResult.hasErrors()) {

			SalesRepresentative salesRepresentative = new SalesRepresentative();
			Address address = new 	Address();	
			theCustomer.setAddress(address);
			theCustomer.setSalesRepresentative(salesRepresentative);
			
			theSalesRepresentatives = salesRepresentativeService.getSalesRepresentatives();
			theModel.addAttribute("customer", theCustomer);
			theModel.addAttribute("salesRepresentatives", theSalesRepresentatives);
						
			return "customers/customer-form";

		}
		theCustomer.getAddress().setCountry(counttryName);
		theCustomer.getAddress().setState(stateName);
		counttryName ="";
		stateName= "";
		customerService.saveCustomer(theCustomer);
		  
		   return "redirect:/customers/list";
	}

	@ExceptionHandler({ Exception.class })
	@GetMapping("/showFormForUpdatCustomer")
	public String showFormForUpdateCustomer(@RequestParam("custumerId") Integer  theId ,Model theModel ) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customers/customer-form";

	}

	@ResponseBody
	@GetMapping("country/{id}/{name}")
	public String loadStatesByCountry(@PathVariable Integer id, @PathVariable String name) {
		counttryName ="";
		Gson gson = new Gson();
		counttryName =name;
		return gson.toJson(stateService.findByCountryId(id));
	}

	@ResponseBody
	@GetMapping("state/{id}/{name}")
	public String loadCitiesByState(@PathVariable Integer id, @PathVariable String name) {
		stateName ="";
		System.out.println("State name and id: "+ " " + id +"   " + name);
		stateName = name;
		Gson gson = new Gson();
		return gson.toJson(cityService.findByStateId(id)); 

}
	
	
}
