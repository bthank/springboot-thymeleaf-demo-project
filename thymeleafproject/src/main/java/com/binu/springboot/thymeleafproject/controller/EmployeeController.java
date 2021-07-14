package com.binu.springboot.thymeleafproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// set up model attribute to bind the form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee",theEmployee);
		
		// return the html template we want to use for the form; found in src/main/resources/templates/
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {  // "employeeId" was passed by the form to the controller
		
		// set up model attribute to bind the form data
		Employee theEmployee = employeeService.findById(theId);
		
		// set the employee as an attribute in the model to pre-populate the update form
		theModel.addAttribute("employee",theEmployee);
		
		// return the html template we want to use for the form; found in src/main/resources/templates/
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions using a post-redirect-get pattern
		return "redirect:/employees/list";
		
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.update(theEmployee);
		
		// use a redirect to prevent duplicate submissions using a post-redirect-get pattern
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {  // "employeeId" was passed by the form to the controller
		
		employeeService.deleteById(theId);
		
		// use a redirect to prevent duplicate submissions using a post-redirect-get pattern
		return "redirect:/employees/list";
		
	}
}
