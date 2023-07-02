package com.employeeinout.inoutservice;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeinout.employeeservice.EmployeeService;
import com.employeeinout.inoutrepository.InOutRepository;
import com.employeeinout.models.Employee;
import com.employeeinout.models.InOutRecord;
@Service
public class InOutServiceImp implements InOutService
{
   @Autowired
   InOutRepository repo;
   @Autowired
   EmployeeService employeeService;

public void saveOutTime(InOutRecord inOut) {
	Employee emp=employeeService.getEmployee(inOut.getEid());
	inOut.setName(emp.getFirstName());
	inOut.setDate(LocalDate.now().toString());
	inOut.setOutTime(LocalTime.now().toString());
	repo.save(inOut);
}
   
}
