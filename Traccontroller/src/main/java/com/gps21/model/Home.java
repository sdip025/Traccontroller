package com.gps21.model;

import javax.validation.constraints.Size;

public class Home {
	
	
	@Override
	public String toString() {
		return "Home [existedpassword=" + existedpassword + ", newpassword="
				+ newpassword + ", confirmpassword=" + confirmpassword + "]";
	}
	private String existedpassword;
	
	@Size(min=3,max=10)
	private String newpassword;
	
	
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
