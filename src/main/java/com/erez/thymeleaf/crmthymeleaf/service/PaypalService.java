package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import com.erez.thymeleaf.crmthymeleaf.exception.RemoteServiceNotAvailableException;

import com.erez.thymeleaf.crmthymeleaf.entity.Customer;


public interface CustomerService {
	
	 public List<Customer> getCustomers();

	 public void saveCustomer(Customer theCustomer);

	 @Retryable(value = { RemoteServiceNotAvailableException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	 public Customer getCustomer(Integer theId);

	 public void deleteCustomer(Integer theId);
	
	 public List<Customer> searchCustomerByName(String theName);
	
	 public Page<Customer> getAllCustomersPaginated(Pageable pageable);
	
	 public Page<Customer> searchCustomerByName(String theName, Pageable pageable );
	 
	
	 
	 @Recover
	public String getBackendResponseFallback(RuntimeException e);

}
