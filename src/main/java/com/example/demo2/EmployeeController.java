package com.example.demo2;

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
	
	//Constructor injection of EmployeeReposioty dependency
	EmployeeController(EmployeeRepository repository){
		this.repository = repository;
	}
	
	
	@GetMapping("/employee/{id}")
	public EntityModel<Employee> getEmployeeById(@PathVariable Long id){
		Employee emp = repository.findById(id)
								.orElseThrow(() -> new EmployeeNotFoundException(id));
		return EntityModel.of(emp,WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
						.methodOn(EmployeeController.class).getEmployeeById(id)
						).withSelfRel()
				);
		/**
		 * linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel() asks that 
		 * Spring HATEOAS build a link to the EmployeeController's getEmployeeById() method, 
		 * and flag it as a self link.
		 */
	}
	
	@GetMapping("/employees")
	public CollectionModel<EntityModel<Employee>> findAllEmployees(){
		List<EntityModel<Employee>> employees = repository.findAll()
				  .stream()
				  .map(emp -> EntityModel.of(emp, 
				   WebMvcLinkBuilder.linkTo(
				   WebMvcLinkBuilder.methodOn(EmployeeController.class).
				   getEmployeeById(emp.getId()))
				  .withSelfRel()))
				  .collect(Collectors.toList());
		return CollectionModel.of(employees,
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
					.methodOn(EmployeeController.class).findAllEmployees())
			.withSelfRel());
	
	} 
}
