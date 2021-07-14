package com.binu.springboot.thymeleafproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binu.springboot.thymeleafproject.entity.Employee;
import com.binu.springboot.thymeleafproject.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//	private List<Employee> theEmployees;
//	
//	@PostConstruct
//	private void loadData() {
//		
//		// create employees
//		Employee emp1 = new Employee(1,"John","Meyer","john.meyer@gmail.com");
//		Employee emp2 = new Employee(2,"Anna","Stevens","anna.stevens@gmail.com");
//		Employee emp3 = new Employee(3,"Karli","Lloyd","karli.lloyd@gmail.com");
//		
//		// create the list
//		theEmployees = new ArrayList<Employee>();
//		
//		// add employees to the list
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//	}
	
	EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> employees = employeeService.findAll();
		theModel.addAttribute("employees",employees);
		
		return "list-employees";
	}
	
	
}
