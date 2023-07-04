package com.employeeinout.reportservice;

import java.util.List;

import com.employeeinout.models.InOutRecord;

public interface ReportService {

	List<InOutRecord> getEmployeeReport(int eid);

	List<InOutRecord> getDateReport(String date);

}
