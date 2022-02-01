package com.pack.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pack.exception.EmployeeNotFoundException;
import com.pack.model.Employee;
import com.pack.service.EmployeeService;

@Controller
public class EmployeeController {
	
	final static Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
    EmployeeService employeeService;

	@RequestMapping("/add")
	public String toAdd(Model model) {
		    
		  logger.info("into add");
		model.addAttribute("empBean",new Employee());
	 		return  "emp";
		}
	

	@RequestMapping("/save")
	public String saveEmp(@ModelAttribute("empBean") Employee employee)
	{ 
		  logger.info("into save");
	 
	//  logger.error("Saving emp object"+employee);
		employeeService.saveEmployee(employee);
		return "welcome";
	}
	
	

	
	  @RequestMapping(value="/getId", method = RequestMethod.GET)
	  public String  getId() {
	  
	  return "getIdForm"; 
	  }
	  
	  
	  @RequestMapping(value="/getIdMod", method = RequestMethod.GET) 
	  public String   getIdMod()
	  {
		  logger.info("into getIdMod");
	  return "getIdModForm";
	  
	  }
	  
	  
	  @RequestMapping(value="/del", method = RequestMethod.POST)
	  public String  delete(@RequestParam("id") int id,Employee employee,Model m) 
	  {
	  
	  String page=null;
	  try { 
		  if (employeeService.getEmployeeById(id).isPresent())
	          { 
			  employee=employeeService.getEmployeeById(id).get();
	          employeeService.deleteEmployee(employee);
	          page="pageSuccess";
	      } else if  (employeeService.getEmployeeById(id).isEmpty()) {
	          System.out.println("emp "+employee);
	           throw new EmployeeNotFoundException();
	  
	            } 
		  } catch(EmployeeNotFoundException e)
	  
	  { 
			  m.addAttribute("exception",e);
	          page="ExceptionPage";
	  
	  }
	  
	  return page;
	 
	 
}


@RequestMapping(value="/update", method = RequestMethod.POST)  
public String update(@RequestParam("id") int  id,Model m)
{
	Employee employee=null;
	String page=null;
	try
			{
	 if (employeeService.getEmployeeById(id).isPresent())
	 {
		  employee=employeeService.getEmployeeById(id).get();
		  m.addAttribute("updateBean", employee);
		  page="showUpdateForm";
		 
	 }
	 else if (employeeService.getEmployeeById(id).isEmpty())
	 {
		 System.out.println("emp "+employee);
	  throw new EmployeeNotFoundException();
	   
		  }
		}
		  catch(EmployeeNotFoundException e)
		  {
			  m.addAttribute("exception",e);
		    	page="ExceptionPage";
			 
		  }

     return page;
	
}


  @RequestMapping("/viewForm") 
  public String viewemp(Model m){
	  List<Employee>   list=employeeService.viewAll(); 
	  m.addAttribute("list",list); 
	  return "view";
	  }
 
 
  @RequestMapping("/myQuery") 
  public String myQuery()
  {
	  System.out.println("in my query");
	  return "myQuery";
  }
  
  
  @RequestMapping("/result") 
  public String getName(@RequestParam("ename")String name,@RequestParam("desig")String desig,Model m)
  {
	  System.out.println("desig "+desig);
	  Employee emp=employeeService.getEmployee(name, desig);
	  
	  m.addAttribute("emp", emp);
	  return "resultPage";
	  
  }
  
  @RequestMapping("/findByDesig") 
  public String findByDesig()
  {
	  
	  return "getDesig";
  }
  @RequestMapping("/getDetails") 
  public String getName(@RequestParam("desig")String desig,Model m)
  {
	  System.out.println("desig "+desig);
	  List<Employee> list=employeeService.findByDesig(desig);
	  System.out.println("list "+list);
	  m.addAttribute("list", list);
	  return "desigPage";
	  
  }
  
  @RequestMapping("/DesigAndName")
  public String findbyDesigName()
  {
	 
	  return "empDesigAndName";
  }
  @RequestMapping("/getDetailsNameDesig")
  public String getNameAndDesig(@RequestParam("name")String name,@RequestParam("desig")String desig, Model m)
  {
Employee list=employeeService.getDesigNam(name, desig);
m.addAttribute("list",list);
	  return "desigAndName";
	  
  }
}

 
