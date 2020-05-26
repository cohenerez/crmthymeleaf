package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;

import com.erez.thymeleaf.crmthymeleaf.entity.Address;


public interface AddressService {
	
	public List<Address> getAddresses();

	public void saveAddress(Address theAddress);

	public Address getAddress(Integer theId);

	public void deleteAddress(Integer theId);

}
