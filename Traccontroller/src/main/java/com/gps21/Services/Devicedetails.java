package com.gps21.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.gps21.model.Deviceproperties;
import com.gps21.model.Devices;
import com.gps21.model.Userinput;

public interface Devicedetails {

	public HashMap<String, String[]> deviceposition(String uname);

	public  Deviceproperties updateposition(Userinput devicename);

}
