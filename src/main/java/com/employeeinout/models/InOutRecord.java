package com.employeeinout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InOutRecord 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ioid;
    private int eid;
    private String name;
    private String date;
    private String inTime;
    private String outTime;
	public int getIoid() {
		return ioid;
	}
	public void setIoid(int ioid) {
		this.ioid = ioid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	@Override
	public String toString() {
		return "InOutRecord [ioid=" + ioid + ", eid=" + eid + ", name=" + name + ", date=" + date + ", inTime=" + inTime
				+ ", outTime=" + outTime + "]";
	}
    
    
}
