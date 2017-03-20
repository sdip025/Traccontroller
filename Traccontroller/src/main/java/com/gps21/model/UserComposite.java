package com.gps21.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class UserComposite implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id")
	private Users users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "devices_id")
	private Devices devices;
	
	public UserComposite(Users users, Devices devices) {
		super();
		this.users = users;
		this.devices = devices;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Devices getDevices() {
		return devices;
	}

	public void setDevices(Devices devices) {
		this.devices = devices;
	}

	private long users_id;
	private long devices_id;

	public UserComposite() {
	};

	public UserComposite(long users_id, long devices_id) {
		this.users_id = users_id;
		this.devices_id = devices_id;
	}

	public long getUsers_id() {
		return users_id;
	}

	public void setUsers_id(long users_id) {
		this.users_id = users_id;
	}

	public long getDevices_id() {
		return devices_id;
	}

	public void setDevices_id(long devices_id) {
		this.devices_id = devices_id;
	}

	
	
	

}
