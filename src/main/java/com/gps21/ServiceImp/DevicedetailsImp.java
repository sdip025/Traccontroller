package com.gps21.ServiceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.Services.Devicedetls;
import com.gps21.dao.Userdao;
import com.gps21.model.Devicedetails;


@Service
@Transactional
public class DevicedetailsImp implements Devicedetls {

	private Userdao udao;

	@Autowired
	public DevicedetailsImp(Userdao udao) {
		this.udao = udao;

	}

	@Override
	public HashMap<String, Devicedetails> devicedetails(String uname) {
		
		return udao.devicedetails(uname);
	}

	@Override
	public HashMap<String,String[]> deviceposition(String uname) {
		
		
		
		HashMap<String, String[]>abcd=new HashMap<String, String[]>();
		abcd=udao.deviceposition(uname);
		for(Entry<String, String[]> value : abcd.entrySet()){
			System.out.println("List of value" + value);
			
			
		}
		
		return udao.deviceposition(uname);
	}

	@Override
	public HashMap<String, String[]> updateposition(String devicename) {
		// TODO Auto-generated method stub
		return udao.updateposition(devicename);
	}

}
