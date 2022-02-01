package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.model.Employee;
import com.pack.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/")
public String home()

{
	return "index";
	
}
	@RequestMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("empBean",new Employee());
		
		return "emp";
	}
	
	
	@RequestMapping("/save")
	public String save(Employee employee,Model m) 
	{
		m.addAttribute("name",employee);
		employeeService.saveEmployee(employee);
		return "welocome";
		
	}
}
