package com.gps21.dao;

import java.util.HashMap;
import java.util.List;



import com.gps21.model.Devices;
import com.gps21.model.Users;
import com.gps21.model.Positions;
import com.gps21.model.Users;

public interface Userdao {

	public List<Positions> plist();

	public List<Users> ulist();

	public Users userauthentication(String login, String password);

	public List<Devices> dlist(String uname);
	

	
	

}
