package com.employeeinout.employeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeinout.employeerepository.EmployeeRepository;
import com.employeeinout.models.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService
{ 
	@Autowired
   EmployeeRepository repo;

	@Override
	public void addEmployee(Employee emp) {
		repo.save(emp);
		
	}

	
	public List<Employee> getEmployeeList() {
		return repo.findAll();
		
	}


	@Override
	public Employee getEmployee(int eid) {
		
		return repo.findById(eid).orElse(null);
	}
}
