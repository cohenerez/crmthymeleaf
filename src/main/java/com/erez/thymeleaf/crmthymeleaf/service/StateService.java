package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;
import com.erez.thymeleaf.crmthymeleaf.entity.StateDTO;

public interface StateService {
	
	public List<StateDTO> findByCountry(int id);

}
