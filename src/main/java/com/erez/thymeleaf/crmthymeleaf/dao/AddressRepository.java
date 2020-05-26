package com.erez.thymeleaf.crmthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erez.thymeleaf.crmthymeleaf.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
