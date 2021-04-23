package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository){
		this.repository = repository;
	}
	@GetMapping("/employees")
	List<Employee> all(){
		return repository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	Employee findEmployeeById(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
		
	}
}
