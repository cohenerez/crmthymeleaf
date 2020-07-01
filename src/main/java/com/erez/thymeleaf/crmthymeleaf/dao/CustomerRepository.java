package com.erez.thymeleaf.crmthymeleaf.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.erez.thymeleaf.crmthymeleaf.entity.Customer;




public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// add a method to sort by last name
		public List<Customer> findAllByOrderByCustomerNameAsc();
		
		// search by name
		public List<Customer> findByCustomerNameContainsOrContactLastNameContainsAllIgnoreCase(String customerName, String contactLastName);
		
			
}
