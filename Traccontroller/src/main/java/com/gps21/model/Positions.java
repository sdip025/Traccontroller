package com.gps21.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="positions")
@Entity
public class Positions implements  Serializable ,Cloneable{
	
	 private static final long serialVersionUID = 1L;
	
     public  Positions(){
	
     }

     public Positions(Positions position){
	
	   id = position.id;
     
       time = position.time;
       valid = position.valid;
       latitude = position.latitude;
       longitude = position.longitude;
       altitude = position.altitude;
       speed = position.speed;
       course = position.course;
       power = position.power;
       address = position.address;
       other = position.other;
	
     }
     @Id
    @GeneratedValue
     private long id;
 
     private Date time;
     private Boolean valid;
    
     private Double latitude;
     private Double longitude;
     private Double altitude;
     private Double speed;
     private Double course;
     private Double power;
     private String address;
     private String other;
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}



public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}

public Boolean getValid() {
	return valid;
}

public void setValid(Boolean valid) {
	this.valid = valid;
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

public Double getAltitude() {
	return altitude;
}

public void setAltitude(Double altitude) {
	this.altitude = altitude;
}

public Double getSpeed() {
	return speed;
}

public void setSpeed(Double speed) {
	this.speed = speed;
}

public Double getCourse() {
	return course;
}

public void setCourse(Double course) {
	this.course = course;
}

public Double getPower() {
	return power;
}

public void setPower(Double power) {
	this.power = power;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getOther() {
	return other;
}

public void setOther(String other) {
	this.other = other;
}



}
