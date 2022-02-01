package com.pack.repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pack.model.Employee;


@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Integer> 
{

}
