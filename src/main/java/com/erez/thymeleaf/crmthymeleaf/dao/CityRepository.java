package com.erez.thymeleaf.crmthymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erez.thymeleaf.crmthymeleaf.entity.City;
import com.erez.thymeleaf.crmthymeleaf.entity.CityDTO;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
	
	@Query("select new com.erez.thymeleaf.crmthymeleaf.entity.CityDTO(id, name) from City where state.id = :id")
	public List<CityDTO> findByStateId(@Param("id") int id);

}
