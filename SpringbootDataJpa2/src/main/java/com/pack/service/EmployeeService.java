package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Employee;
import com.pack.repositary.*;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	 
	public void saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	 
	}
	
	  public Optional<Employee> getEmployeeById(int id){
	  
	  
	  System.out.println("into");
	  return employeeRepository.findById(id);
	  
	  
	  
	  }
	  
	  public void deleteEmployee(Employee employee)
	  
	  { 
		  employeeRepository.delete(employee);
	  
	  }
	  
	  public void updateEmployee(Employee employee)
	  
	  { employeeRepository.save(employee);
	 
	  
	  }
	  
	  
	  public List<Employee> viewAll()
	  {
		  
		  return employeeRepository.findAll();
	  }
	  
	//custom  
	  public List<Employee> findByDesig(String desig)
	  {
		  
		  
		  return employeeRepository.findByDesig(desig);
	  }
	  
	  public Employee   getEmployee(String name,String desig)
	  {
		  
		  return employeeRepository.getEmployee(name, desig);
	  }
	 public Employee getDesigNam(String name,String desig)

{
	return employeeRepository.getByNameAndDesig(name, desig);
		 }
}
