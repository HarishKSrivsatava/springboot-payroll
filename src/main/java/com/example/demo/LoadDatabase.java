package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	 @Bean
	  CommandLineRunner initDatabase(final EmployeeRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
	      log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
	    };
	  }
	
	 /**
	  * What happens when it gets loaded?
		1.Spring Boot will run ALL CommandLineRunner beans once the application 
		  context is loaded.
		2.This runner will request a copy of the EmployeeRepository you just created.
		3.Using it, it will create two entities and store them.
	  */
}
