package com.erez.thymeleaf.crmthymeleaf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.erez.thymeleaf.crmthymeleaf.entity.Customer;

public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Customer> findCustomerByName(Set<String> names) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
		Root<Customer> customer = query.from(Customer.class);
		Path<String> customerNamePath = customer.get("customerName");
		
		 List<Predicate> predicates = new ArrayList<>();
		
		 for (String name : names) {
	            predicates.add(cb.like(customerNamePath, name));
	  }
		 
		 query.select(customer).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
		 
		 return entityManager.createQuery(query).getResultList();
	}

}
