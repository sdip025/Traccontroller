package com.gps21.model;

public  final class Devicedetails {
	
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
	
	public Devicedetails(){
		
	};
	Double latitude;
	Double longitude;
	Double speed;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPositiontime() {
		return positiontime;
	}
	public void setPositiontime(String positiontime) {
		this.positiontime = positiontime;
	}
	public String getStoptime() {
		return stoptime;
	}
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}
	public String getPositiontype() {
		return positiontype;
	}
	public void setPositiontype(String positiontype) {
		this.positiontype = positiontype;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getAddress() {
		return address;
	}
	public void setAddress(Double address) {
		this.address = address;
	}

	Double address;
	
	
	
	

}
