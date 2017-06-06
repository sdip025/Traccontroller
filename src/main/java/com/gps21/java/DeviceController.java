package com.gps21.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gps21.Services.Devicedetls;
import com.gps21.Services.UserService;
import com.gps21.model.Devicedetails;
import com.gps21.model.Devices;

@Controller
public class DeviceController {

	private Devicedetls devicedetails;

	@Autowired
	public DeviceController(Devicedetls devicedetails) {
		this.devicedetails = devicedetails;

	}

	@ResponseBody
	@RequestMapping(value = "/devicedetails", method = RequestMethod.GET, produces = "application/json")
	public HashMap<String, String[]> devicedetails(HttpSession session) {
		String uname = (String) session.getAttribute("username");

		HashMap<String, String[]> abcd = devicedetails.deviceposition(uname);

		for (Entry<String, String[]> entry : abcd.entrySet()) {

			String key = entry.getKey();

		}

		return devicedetails.deviceposition(uname);
	}
	@ResponseBody
	@RequestMapping(value="/sddetails",method = RequestMethod.GET, produces = "application/json")
	public HashMap<String, String[]>selectdevicename(){
		String  devicename="vs1 xyz";
		
		return devicedetails.updateposition(devicename);
	}
	
	

}
