package com.gps21.model;

import java.util.Date;


public class Userinput {
	
	
	
	private String selecteddevice;
	
public String getSelecteddevice() {
		return selecteddevice;
	}
	public void setSelecteddevice(String selecteddevice) {
		this.selecteddevice = selecteddevice;
	}
private String username;
	public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
	private Date fdata;
	private Date tdate;
	
	public Date getFdata() {
		return fdata;
	}
	public void setFdata(Date fdata) {
		this.fdata = fdata;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	private String fromdate;
	private String todate;
	private String devicename;
	private int givenfuelconsumption;
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public int getGivenfuelconsumption() {
		return givenfuelconsumption;
	}
	public void setGivenfuelconsumption(int givenfuelconsumption) {
		this.givenfuelconsumption = givenfuelconsumption;
	}

}
