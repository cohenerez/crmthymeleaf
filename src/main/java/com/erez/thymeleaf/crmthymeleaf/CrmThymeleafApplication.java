package com.erez.thymeleaf.crmthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class CrmThymeleafApplication {

	public static void main(String[] args) {
		 SpringApplication.run(CrmThymeleafApplication.class, args);
	
		
	
	}

}

