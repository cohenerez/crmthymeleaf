package com.erez.thymeleaf.crmthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erez.thymeleaf.crmthymeleaf.dao.CountryRepository;
import com.erez.thymeleaf.crmthymeleaf.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	
	private CountryRepository countryRepository; 
	
	
	@Autowired
	public CountryServiceImpl(CountryRepository theCountryRepository) {
	
		countryRepository = theCountryRepository;
	}

	@Override
	public Iterable<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country find(int id) {
		return countryRepository.findById(id).get();
	}

}
