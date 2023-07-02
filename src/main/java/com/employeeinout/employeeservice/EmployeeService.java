package com.employeeinout.employeeservice;

import java.util.List;

import com.employeeinout.models.Employee;

public interface EmployeeService 
{

	void addEmployee(Employee emp);

	List<Employee> getEmployeeList();

	Employee getEmployee(int eid);

}
