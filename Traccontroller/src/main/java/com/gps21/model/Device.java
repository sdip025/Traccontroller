package com.gps21.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="devices")
public class Device implements Serializable {
	

	private static final long serialVersionUID = 1L;
	public Device (){
		
	}
	
	
	public Device(Device device){
		id=device.id;
		uniqueid=device.uniqueid;
		name=device.name;
		
		}
	
    @Id
    @GeneratedValue
	private long id;
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUniqueid() {
		return uniqueid;
	}


	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Position getLatestPosition() {
		return latestPosition;
	}


	public void setLatestPosition(Position latestPosition) {
		this.latestPosition = latestPosition;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private String uniqueid;
    private String name;
    private Position latestPosition;
	

}
