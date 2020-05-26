package com.erez.thymeleaf.crmthymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.erez.thymeleaf.crmthymeleaf.entity.SalesRepresentative;


public interface SalesRepresentativeRepository extends JpaRepository<SalesRepresentative, Integer> {

	// add a method to sort by last name
			public List<SalesRepresentative> findAllByOrderByLastNameAsc();
			
			// search by name
			public List<SalesRepresentative> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String firstName, String lastName);
	
}
