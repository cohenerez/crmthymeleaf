package com.erez.thymeleaf.crmthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erez.thymeleaf.crmthymeleaf.entity.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

}
