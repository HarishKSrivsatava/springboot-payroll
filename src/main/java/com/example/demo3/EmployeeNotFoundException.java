package com.example.demo3;

public class EmployeeNotFoundException extends RuntimeException{
	EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}

	
}
