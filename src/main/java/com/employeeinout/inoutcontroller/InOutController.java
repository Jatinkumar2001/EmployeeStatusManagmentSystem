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
public class InOutController {
	@Autowired
	InOutService service;
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("outTime")
	public String getOutView(Model model) {
		model.addAttribute("elist", employeeService.getEmployeeList());
		return "InOut/OutTime";
	}
	
	@RequestMapping("inTime")
	public String getInView(Model model) {
		model.addAttribute("elist", employeeService.getEmployeeList());
		return "InOut/InTime";
	}

	@RequestMapping("addOutTime")
	public String addOutTime(Model model, InOutRecord inOut) {
		int done = service.saveOutTime(inOut);
		if (done==2) {
			model.addAttribute("elist", employeeService.getEmployeeList());
			model.addAttribute("msg", "Out time saved .. ");
		} else if(done==1){
			model.addAttribute("elist", employeeService.getEmployeeList());
			model.addAttribute("msg", "Employee is not in yet");
		}
		return "InOut/OutTime";
	}
	
	@RequestMapping("addInTime")
	public String addInTime(Model model, InOutRecord inOut) {
		int done = service.saveInTime(inOut);
		if (done==2) {
			model.addAttribute("elist", employeeService.getEmployeeList());
			model.addAttribute("msg", "Employee is already in..");
		} else if(done==1){
			model.addAttribute("elist", employeeService.getEmployeeList());
			model.addAttribute("msg", "Employee attendece marked");
		}
		return "InOut/InTime";
	}
}
