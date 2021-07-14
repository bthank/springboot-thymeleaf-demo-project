package com.binu.springboot.thymeleafproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/demo1")
	public String displayDateOnServer(Model theModel) {
		
		theModel.addAttribute("theDate",new java.util.Date());
		
		
		// ThymeLeaf will look for demo.html in source/main/resources/templates
		return "demo";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
