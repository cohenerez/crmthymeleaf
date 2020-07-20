package com.erez.thymeleaf.crmthymeleaf.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.erez.thymeleaf.crmthymeleaf.entity.Customer;
import com.erez.thymeleaf.crmthymeleaf.entity.Order;




public interface OrderRepository extends JpaRepository<Customer, Integer> {

	// add a method to sort by last name
		public List<Order> findAllByOrderByCustomerNameAsc();
		
		// search by name
		public List<Order> findByCustomerNameContainsOrContactLastNameContainsAllIgnoreCase(String customerName, String contactLastName);
		
			
}
