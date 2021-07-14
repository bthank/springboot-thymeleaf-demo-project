package com.binu.springboot.thymeleafproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binu.springboot.thymeleafproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// add a method to sort by last name; Spring Data JPA will create the appropriate sort query behind the scenes
	public List<Employee> findAllByOrderByLastNameAsc();
	

}
