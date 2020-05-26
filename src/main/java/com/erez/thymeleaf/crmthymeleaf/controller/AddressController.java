package com.erez.thymeleaf.crmthymeleaf.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erez.thymeleaf.crmthymeleaf.entity.Address;
import com.erez.thymeleaf.crmthymeleaf.service.AddressService;
import com.erez.thymeleaf.crmthymeleaf.service.CityService;
import com.erez.thymeleaf.crmthymeleaf.service.CountryService;
import com.erez.thymeleaf.crmthymeleaf.service.StateService;
import com.google.gson.Gson;



@Controller
@RequestMapping("/addresses")
public class AddressController {

	
	private AddressService addressService;
	private CountryService countryService;
	private StateService stateService;
	private CityService cityService;
	
	
	@Autowired
	public AddressController(AddressService theAddressService ,	CountryService theCountryService,
			StateService theStateService, CityService theCityService){
		  addressService= theAddressService;
		  countryService = theCountryService;
		  stateService = theStateService;
		  cityService = theCityService;
		
	}
	
 
	@GetMapping("shwoFromToAddAddress")
	String shwoFromToAddAddress( Model theModel) {
		
		
		//Model theModel,
		Address theAddress = new Address();
		theModel.addAttribute("address", theAddress);
		//modelMap.put("address", theAddress);
		//modelMap.put("countries", countryService.findAll());
		theModel.addAttribute("countries", countryService.findAll());
		
		return "addresses/address-form";
   }
	
	
	
	@PostMapping("save")
	String SaveAddress(@ModelAttribute("address") @Valid Address theAddress, 
			BindingResult bindingResult ,Model theModel) {
		
		if (bindingResult.hasErrors()) {
						
			theModel.addAttribute("address", theAddress);
						
			return "addresses/addresses-form";
		}
		
		addressService.saveAddress(theAddress);
		return "redirect:/customers/customer-form";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ResponseBody
	@GetMapping("loadStatesByCountry/{id}")
	public String loadStatesByCountry(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(stateService.findByCountry(id));
	}
	
	@ResponseBody
	@GetMapping("loadCitiesByState/{id}")
	public String loadCitiesByState(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(cityService.findByState(id));
}
}
