package com.employeeinout.employeerepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeinout.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
