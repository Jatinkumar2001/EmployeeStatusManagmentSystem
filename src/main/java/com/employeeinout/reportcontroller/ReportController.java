package com.employeeinout.reportcontroller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeeinout.employeeservice.EmployeeService;
import com.employeeinout.inoutservice.InOutService;
import com.employeeinout.models.InOutRecord;
import com.employeeinout.reportservice.ReportService;

@Controller
@RequestMapping("WorkForceManagment/report")
public class ReportController {
	@Autowired
	ReportService service;
	@Autowired
	EmployeeService eservice;

	@RequestMapping("employee")
	public String getEmployeeReportView(Model model) {
		model.addAttribute("elist", eservice.getEmployeeList());
		return "Report/EmployeeWise";
	}

	@RequestMapping("getEmployeeReport")
	public String getEmployeeReport(int eid, Model model) {
		List<InOutRecord> lst = service.getEmployeeReport(eid);
		model.addAttribute("rlist", lst);
		return "Report/ReportView";
	}

	@RequestMapping("date")
	public String getdateReportView(Model model) {

		return "Report/DateWise";
	}

	@RequestMapping("getDateReport")
	public String getDateReport(String date, Model model) {
		List<InOutRecord> lst = service.getDateReport(date);
		model.addAttribute("rlist", lst);
		return "Report/ReportView";
	}

	@RequestMapping("currentDateReport")
	public String getCurrentDateReport(Model model) {
		List<InOutRecord> lst = service.getDateReport(LocalDate.now().toString());
		model.addAttribute("rlist", lst);

		return "Report/ReportView";
	}

}
