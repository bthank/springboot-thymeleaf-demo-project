package com.binu.springboot.thymeleafproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binu.springboot.thymeleafproject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
