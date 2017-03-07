package com.gps21.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;



@Entity
@Table(name = "devices")
public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Device() {

	}

	public Device(Device device) {
		id = device.id;
		uniqueid = device.uniqueid;
		name = device.name;

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

	public Positions getLatestPosition() {
		return latestPosition;
	}

	public void setLatestPosition(Positions latestPosition) {
		this.latestPosition = latestPosition;
	}

	private String uniqueid;
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Positions latestPosition;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="device")
	private List<Positions>dposition=new ArrayList<Positions>();
	
	
	
	
	
}
