package com.gps21.Services;




public class Devicedetails {
	
	String dname;
	String imei;
	String status;
	String positiontime;
	String stoptime;
	String positiontype;
	String direction;
	public Devicedetails(String dname, String imei, String status,
			String positiontime, String stoptime, String positiontype,
			String direction, Double latitude, Double longitude, Double speed,
			Double address) {
		super();
		this.dname = dname;
		this.imei = imei;
		this.status = status;
		this.positiontime = positiontime;
		this.stoptime = stoptime;
		this.positiontype = positiontype;
		this.direction = direction;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.address = address;
	}
	Double latitude;
	Double longitude;
	Double speed;
	Double address;
	
	
	
	

}
