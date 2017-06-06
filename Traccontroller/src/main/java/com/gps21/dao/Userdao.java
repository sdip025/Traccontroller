package com.gps21.dao;


import java.util.HashMap;


import com.gps21.model.Changepassword;
import com.gps21.model.Deviceproperties;

import com.gps21.model.Statistics;
import com.gps21.model.Userinput;
import com.gps21.model.Users;

public interface Userdao {

	public Users userauthentication(String login, String password);

	public String updatepassword(Changepassword username);

	public HashMap<String, String[]> deviceposition(String uname);

	public  Deviceproperties updateposition(
			Userinput devicename);

	public Statistics mileagereport(Userinput userinput);

}
