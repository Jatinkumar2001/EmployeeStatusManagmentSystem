package com.employeeinout.inoutservice;

import java.util.List;

import com.employeeinout.models.InOutRecord;

public interface InOutService 
{



	int saveInTime(InOutRecord inOut);

	int saveOutTime(InOutRecord inOut);


}
