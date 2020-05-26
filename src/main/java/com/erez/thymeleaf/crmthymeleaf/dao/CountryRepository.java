package com.erez.thymeleaf.crmthymeleaf.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erez.thymeleaf.crmthymeleaf.entity.Country;

@Repository("countryRepository")
public interface CountryRepository extends CrudRepository<Country, Integer> {

}