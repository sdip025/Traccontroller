/*package com.gps21.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_devices" , catalog = "traccar")
public class Userdevice implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private UserComposite ucomvalue;

	public UserComposite getUcomvalue() {
		return ucomvalue;
	}

	public void setUcomvalue(UserComposite ucomvalue) {
		this.ucomvalue = ucomvalue;
	}
	@Column(name = "users_id")
	private long users_id;
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
	@Column(name = "devices_id")
	private long devices_id;
	
	

}
*/