package com.example.demo3;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.*;

@RestController
public class EmployeeController {
	
	private EmployeeRepository repository;
	private EmployeeModelAssembler employeeModelAssembler;
	
	//Constructor injection of EmployeeReposioty dependency
	EmployeeController(EmployeeRepository repository, EmployeeModelAssembler employeeModelAssembler){
		this.repository = repository;
		this.employeeModelAssembler = employeeModelAssembler;
	}
	@GetMapping("/employee/{id}")
	public EntityModel<Employee> getEmployeeById(@PathVariable Long id){
		Employee emp = repository.findById(id)
								.orElseThrow(() -> new EmployeeNotFoundException(id));
		return employeeModelAssembler.toModel(emp);
	}
	
	@GetMapping("/employees")
	public CollectionModel<EntityModel<Employee>> findAllEmployees(){
		List<EntityModel<Employee>> employees = repository.findAll()
				  .stream()
				  .map(employeeModelAssembler::toModel)
				  .collect(Collectors.toList());
	return CollectionModel.of(employees,
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
					.methodOn(EmployeeController.class)
					.findAllEmployees()).withSelfRel());
	
	} 
}
