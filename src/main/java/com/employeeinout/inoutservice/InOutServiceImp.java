package com.employeeinout.inoutservice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeinout.employeeservice.EmployeeService;
import com.employeeinout.inoutrepository.InOutRepository;
import com.employeeinout.models.Employee;
import com.employeeinout.models.InOutRecord;

@Service
public class InOutServiceImp implements InOutService {
	@Autowired
	InOutRepository repo;
	@Autowired
	EmployeeService employeeService;

	@Override
	public int saveInTime(InOutRecord inOut) {
		InOutRecord out = null;
		List<InOutRecord> list = repo.getInOutRecord(inOut.getEid(), LocalDate.now().toString());
		if (!list.isEmpty()) {
			out = list.get(list.size() - 1);
		}
		if (out == null || out.getOutTime() != null) {
			Employee emp = employeeService.getEmployee(inOut.getEid());
			inOut.setName(emp.getFirstName());
			inOut.setDate(LocalDate.now().toString());
			LocalTime time=LocalTime.now();
			LocalTime currentTime=LocalTime.of(time.getHour(), time.getMinute());
			inOut.setInTime(currentTime.toString());
			repo.save(inOut);
			return 1;
		} else if (out.getOutTime() == null) {
			return 2;
		}
		return 0;
	}

	@Override
	public int saveOutTime(InOutRecord inOut) {
		InOutRecord out = null;
		List<InOutRecord> list = repo.getInOutRecord(inOut.getEid(), LocalDate.now().toString());
		if (!list.isEmpty()) {
			out = list.get(list.size() - 1);
			if (out.getInTime() != null && out.getOutTime() == null) {
				LocalTime time=LocalTime.now();
				LocalTime currentTime=LocalTime.of(time.getHour(), time.getMinute());
				repo.updateOutRecord(currentTime.toString(), inOut.getEid(), LocalDate.now().toString());
				return 2;

			}
		}
		return 1;

	}

}
