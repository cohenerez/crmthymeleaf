package com.erez.thymeleaf.crmthymeleaf.dao;



import java.util.List;
import java.util.Set;

import com.erez.thymeleaf.crmthymeleaf.entity.Customer;




public interface CustomerRepositoryCustom  {

	 List<Customer> findCustomerByName(Set<String> customerName);
			
}
