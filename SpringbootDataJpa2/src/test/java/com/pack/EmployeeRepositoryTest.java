package com.pack;

import java.util.Optional;

 
import org.junit.jupiter.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.pack.model.Employee;
import com.pack.repositary.EmployeeRepository;


 
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	static Employee e;
	
	int id;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		  e=new Employee("testabc","testdesig");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	 

	 @Test
	 
	public void saveEmployeeTest()
	{
	
		employeeRepository.save(e);
		System.out.println(e.getId());
		 id=e.getId();
		Assertions.assertNotNull(e.getId());
		
	}
	

  @Test
  
 
  public void findByIdTest() {
	 Optional<Employee> emp= employeeRepository.findById(id);
     Assertions.assertEquals("testabc", e.getName());
  }
  

}
 

 
 