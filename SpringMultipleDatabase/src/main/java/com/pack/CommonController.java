package com.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.dao.CommonDao;
import com.pack.model.Employee;
import com.pack.model.Student;

@Controller
public class CommonController {
	
	
	@Autowired
    public CommonDao dao;

    @RequestMapping("/emp")
    public String empMeth() {
    	Employee emp=new Employee();
    	emp.setEmpId("100");
    	emp.setEmpName("meera");
    	
      dao.insertEmployee(emp);
      return "result";
      
      
      
    }

	  @RequestMapping("/stud")  
	  public String studMeth() {
	    Student stud=new Student();
	    	stud.setId(300);
	    	stud.setName("Niran");
	    	
	      dao.insertStudent(stud);
	      return "result";
	      
}
}