package com.example.demo2;

public class EmployeeNotFoundException extends RuntimeException{
	EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}

	
}
