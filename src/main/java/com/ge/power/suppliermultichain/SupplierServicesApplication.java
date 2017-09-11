package com.ge.power.suppliermultichain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;/*
import org.springframework.boot.context.web.SpringBootServletInitializer;*/
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication

public class SupplierServicesApplication extends SpringBootServletInitializer{

	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	       return application.sources(SupplierServicesApplication.class);
	    }

	
	
	public static void main(String[] args) {
		SpringApplication.run(SupplierServicesApplication.class, args);
		//LOGGER.info("Started Application..!! ");
		
	}
	
}
	