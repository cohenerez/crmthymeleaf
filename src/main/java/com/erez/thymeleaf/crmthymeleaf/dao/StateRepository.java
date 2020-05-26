package com.erez.thymeleaf.crmthymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erez.thymeleaf.crmthymeleaf.entity.State;
import com.erez.thymeleaf.crmthymeleaf.entity.StateDTO;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {
	
	@Query("select new com.erez.thymeleaf.crmthymeleaf.entity.StateDTO(id, name) from State where country.id = :id")
	public List<StateDTO> findByCountry(@Param("id") int id);

}
