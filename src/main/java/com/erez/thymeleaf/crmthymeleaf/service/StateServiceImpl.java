package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erez.thymeleaf.crmthymeleaf.dao.StateRepository;
import com.erez.thymeleaf.crmthymeleaf.entity.StateDTO;

@Service
public class StateServiceImpl implements StateService {
	
	
	
	
	private StateRepository stateRepository;
	
	
	@Autowired
	public StateServiceImpl(StateRepository theStateRepository) {
	
		stateRepository = theStateRepository;
	}


	@Override
	public List<StateDTO> findByCountryId(Integer id) {
		return stateRepository.findByCountryId(id);
	}


}
