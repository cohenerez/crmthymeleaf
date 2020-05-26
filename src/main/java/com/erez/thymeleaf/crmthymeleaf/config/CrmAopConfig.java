package com.erez.thymeleaf.crmthymeleaf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.erez.thymeleaf.crmthymeleaf.*")
public class CrmAopConfig {

}
