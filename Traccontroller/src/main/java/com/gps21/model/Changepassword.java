package com.gps21.model;

import javax.validation.constraints.Size;

public class Changepassword {
	
	

	
	@Override
	public String toString() {
		return "Home [existedpassword=" + existedpassword + ", newpassword="
				+ newpassword + ", username=" + username + ", confirmpassword="
				+ confirmpassword + "]";
	}
	private String existedpassword;
	
	@Size(min=3,max=10)
	private String newpassword;
	private String username;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String confirmpassword;
	public String getExistedpassword() {
		return existedpassword;
	}
	public void setExistedpassword(String existedpassword) {
		this.existedpassword = existedpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	

}
