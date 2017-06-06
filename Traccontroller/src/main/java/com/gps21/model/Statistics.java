package com.gps21.model;

public class Statistics {

	private String targetname;
	private String time;
	private Double mileage;
	private int alarm;
	private int overspeed;
	private int stay;
	private float fuelconsumption;

	public String getTargetname() {
		return targetname;
	}

	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public int getAlarm() {
		return alarm;
	}

	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	public int getOverspeed() {
		return overspeed;
	}

	public void setOverspeed(int overspeed) {
		this.overspeed = overspeed;
	}

	public int getStay() {
		return stay;
	}

	public void setStay(int stay) {
		this.stay = stay;
	}

	public float getFuelconsumption() {
		return fuelconsumption;
	}

	public void setFuelconsumption(float fuelconsumption) {
		this.fuelconsumption = fuelconsumption;
	}

}
