package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Employee;
import com.pack.repositary.EmployeeRepositary;

@Service
public class EmployeeService
{
	
	
@Autowired
EmployeeRepositary employeeRepositary;

public void saveEmployee(Employee employee)
{
	employeeRepositary.save(employee);
}
}
