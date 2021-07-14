package com.binu.springboot.thymeleafproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binu.springboot.thymeleafproject.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		// create employees
		Employee emp1 = new Employee(1,"John","Meyer","john.meyer@gmail.com");
		Employee emp2 = new Employee(1,"Anna","Stevens","anna.stevens@gmail.com");
		Employee emp3 = new Employee(1,"Karli","Lloyd","karli.lloyd@gmail.com");
		
		// create the list
		theEmployees = new ArrayList<Employee>();
		
		// add employees to the list
		theEmployees.add(emp2);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		theModel.addAttribute("employees",theEmployees);
		
		return "list-employees";
	}
	
	
}
