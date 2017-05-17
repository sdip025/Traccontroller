package com.gps21.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.gps21.model.Devicedetails;
import com.gps21.model.Devices;

public interface Devicedetls {

	public HashMap<String, Devicedetails> devicedetails(String uname);

	public HashMap<String, String[]> deviceposition(String uname);
	
	public HashMap<String,String[]>updateposition(String devicename);

}
