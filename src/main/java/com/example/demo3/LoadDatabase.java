package com.example.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository){
		return arg ->{
			log.info("Preloading "+ repository.save(new Employee("Bilbo Baggins", "Admin")));
			log.info("Preloading "+ repository.save(new Employee("Frodo Baggins", "Manager")));
		};	
	}
}
