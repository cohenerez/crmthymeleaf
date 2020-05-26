package com.erez.thymeleaf.crmthymeleaf.service;

import com.erez.thymeleaf.crmthymeleaf.entity.Country;

public interface CountryService {
	
	public Iterable<Country> findAll();

	public Country find(int id);

}
