package com.gps21.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class UserComposite implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
