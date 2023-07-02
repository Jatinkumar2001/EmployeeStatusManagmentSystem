package com.employeeinout.inoutcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeeinout.employeeservice.EmployeeService;
import com.employeeinout.inoutservice.InOutService;
import com.employeeinout.models.InOutRecord;

@Controller
@RequestMapping("WorkForceManagment/inout")
public class InOutController 
{
   @Autowired
   InOutService service;
   @Autowired
   EmployeeService employeeService;
   
   @RequestMapping("outTime")
   public String getOutView(Model model)
   {
	   model.addAttribute("elist",employeeService.getEmployeeList());
	   return "InOut/OutTime";
   }
   
   @RequestMapping("addOutTime")
   public String addOutTime(Model model,InOutRecord inOut)
   {
	   service.saveOutTime(inOut);
	   model.addAttribute("elist",employeeService.getEmployeeList());
	   model.addAttribute("msg","Out Time Saved Successfully");
	   return "InOut/OutTime";
   }
   
}
