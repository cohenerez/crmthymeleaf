package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import com.erez.thymeleaf.crmthymeleaf.entity.SalesRepresentative;

public  interface SalesRepresentativeService {

	    public List<SalesRepresentative> getSalesRepresentatives();

		public void saveSalesRepresentative(SalesRepresentative theSalesRepresentative);

		public SalesRepresentative getSalesRepresentative(Integer theId);

		public void deleteSalesRepresentative(Integer theId);
	
}
