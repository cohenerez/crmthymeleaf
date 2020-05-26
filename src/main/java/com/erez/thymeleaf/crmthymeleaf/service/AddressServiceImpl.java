package com.erez.thymeleaf.crmthymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erez.thymeleaf.crmthymeleaf.dao.AddressRepository;
import com.erez.thymeleaf.crmthymeleaf.entity.Address;
import com.erez.thymeleaf.crmthymeleaf.exception.NoRecordFoundException;

@Service
public class AddressServiceImpl implements AddressService{
	
	
		@Autowired
		private AddressRepository addressRepository;
		
		@Override
		public List<Address> getAddresses() {
			return addressRepository.findAll();
		}

		@Override
		public void saveAddress(Address theAddress) {

			addressRepository.save(theAddress);
		}

		@Override
		public Address getAddress(Integer theId) {
			
			Address theAddress= null;
			Optional<Address> result = addressRepository.findById(theId);
			if(result.isPresent()) {
				theAddress = result.get();
			}
			else {
				throw new NoRecordFoundException("No Address fund with Address id  :" + theId);
			}
			
			return theAddress;
		}

		@Override
		public void deleteAddress(Integer theId) {
			
			addressRepository.deleteById(theId);
		}

}
