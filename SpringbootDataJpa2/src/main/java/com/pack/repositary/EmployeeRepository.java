package com.pack.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.model.Employee;

@Repository
public interface EmployeeRepository extends   JpaRepository<Employee,Integer>{

	
	public List<Employee> findByDesig(String desig);
	
	@Query("from Employee   where  name = :nam and desig=:desig")
	Employee getEmployee(@Param("nam") String name,@Param("desig")String desig);
	
	
	public Employee getByNameAndDesig(String name,String desig);
	
	
}


