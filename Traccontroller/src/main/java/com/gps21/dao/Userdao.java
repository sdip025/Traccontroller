package com.gps21.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gps21.model.Changepassword;
import com.gps21.model.Devicedetails;
import com.gps21.model.Devices;
import com.gps21.model.Users;
import com.gps21.model.Positions;
import com.gps21.model.Users;

public interface Userdao {

	public List<Positions> plist();

	public List<Users> ulist();

	public Users userauthentication(String login, String password);

	public List<Devices> dlist(String uname);

	public String updatepassword(Changepassword username);

	public List<Users> changepassword(String uname);
	
	public  HashMap<String, Devicedetails>devicedetails(String uname);
	
	public HashMap<String, String []>deviceposition(String uname);
	
	public HashMap<String,String[]>updateposition(String devicename);
	
	
}
