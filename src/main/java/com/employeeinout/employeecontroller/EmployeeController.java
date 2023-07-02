package com.employeeinout.employeecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeeinout.employeeservice.EmployeeService;
import com.employeeinout.models.Employee;

@Controller
@RequestMapping("WorkForceManagment/employee")
public class EmployeeController 
{ 
	
	@Autowired
    EmployeeService service;
	
	@RequestMapping("add")
	public String getAddView()
	{
		return "Employee/Add";
	}
	
	@RequestMapping("add-employee")
	public String addEmployee(Employee emp,Model model)
	{
		service.addEmployee(emp);
		model.addAttribute("flag", '1');
		model.addAttribute("message", "Employee added Sucessfully...");
		return "Employee/Add";
	}
}
