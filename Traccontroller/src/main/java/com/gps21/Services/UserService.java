package com.gps21.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gps21.model.Changepassword;
import com.gps21.model.Devices;
import com.gps21.model.Users;
import com.gps21.model.Positions;


public interface UserService {
	public List<Positions> plist();

	public List<Users> ulList();

	public Users userauthentication(String login, String password);

	public ArrayList<Devices> dlist(String uname);
	
	public HashMap<String, List<Devices>> devicelist(String username);
	
	public String updatepassword(Changepassword users);
	

}
