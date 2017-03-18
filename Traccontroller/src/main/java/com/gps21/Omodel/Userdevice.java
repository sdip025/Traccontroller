package com.gps21.Omodel;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_devices")
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

}
