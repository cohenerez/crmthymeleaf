package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import com.erez.thymeleaf.crmthymeleaf.entity.Office;

public interface OfficeService {
	
	public List<Office> getOffices();

	public void saveOffice(Office theOffice);

	public Office getOffice(int theId);

	public void deleteOffice(int theId);

}
