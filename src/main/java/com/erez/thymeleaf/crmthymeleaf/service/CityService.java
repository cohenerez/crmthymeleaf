package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import com.erez.thymeleaf.crmthymeleaf.entity.CityDTO;

public interface CityService {
	
	public List<CityDTO> findByStateId(Integer id);


}
