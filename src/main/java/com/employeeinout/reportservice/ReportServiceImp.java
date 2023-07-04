package com.employeeinout.reportservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeinout.inoutrepository.InOutRepository;
import com.employeeinout.models.InOutRecord;

@Service
public class ReportServiceImp implements ReportService{
@Autowired
InOutRepository irepo;


public List<InOutRecord> getEmployeeReport(int eid) {
	List<InOutRecord> lst =irepo.findbyEid(eid);
	return lst;
}


@Override
public List<InOutRecord> getDateReport(String date) {
	List<InOutRecord> lst =irepo.findbyDate(date);
	return lst;
}

}
