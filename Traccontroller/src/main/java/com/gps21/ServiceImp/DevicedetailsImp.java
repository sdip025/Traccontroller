package com.gps21.ServiceImp;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.Services.Devicedetails;
import com.gps21.dao.Userdao;
import com.gps21.model.Deviceproperties;
import com.gps21.model.Userinput;


@Service
@Transactional
public class DevicedetailsImp implements Devicedetails {

	private Userdao udao;

	@Autowired
	public DevicedetailsImp(Userdao udao) {
		this.udao = udao;

	}

	@Override
	public  Deviceproperties updateposition(Userinput devicename) {
	
		return udao.updateposition(devicename);
	}

	@Override
	public HashMap<String, String[]> deviceposition(String uname) {
		
		return udao.deviceposition(uname);
	}

}
