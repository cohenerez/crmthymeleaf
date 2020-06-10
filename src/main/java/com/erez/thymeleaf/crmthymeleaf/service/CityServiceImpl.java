package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erez.thymeleaf.crmthymeleaf.dao.CityRepository;
import com.erez.thymeleaf.crmthymeleaf.entity.CityDTO;

@Service
public class CityServiceImpl  implements CityService{

	
	
	private CityRepository cityRepository;
	
	
	@Autowired
	public CityServiceImpl(CityRepository theCityRepository) {
		
		cityRepository = theCityRepository;
	}


	@Override
	public List<CityDTO> findByStateId(Integer id) {
		return cityRepository.findByStateId(id);
	}



	
}
