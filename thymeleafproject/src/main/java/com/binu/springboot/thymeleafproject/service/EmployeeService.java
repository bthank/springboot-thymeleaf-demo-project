package com.binu.springboot.thymeleafproject.service;

import java.util.List;

import com.binu.springboot.thymeleafproject.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void update(Employee theEmployee);
	
	public void deleteById(int theId);
	
	
	
}
