package com.gps21.ServiceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.model.Devices;
import com.gps21.Services.Devicedetails;
import com.gps21.Services.UserService;
import com.gps21.dao.Userdao;
import com.gps21.model.Changepassword;
import com.gps21.model.Positions;
import com.gps21.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final Userdao udo;

	@Autowired
	public UserServiceImpl(Userdao udo) {
		this.udo = udo;
	}

	@Override
	@Transactional
	public List<Positions> plist() {
		return udo.plist();
	}

	@Override
	public List<Users> ulList() {
		return udo.ulist();
	}

	@Override
	public Users userauthentication(String login, String password) {

		return udo.userauthentication(login, password);
	}

	@Override
	public ArrayList<Devices> dlist(String uname) {

		return (ArrayList<Devices>) udo.dlist(uname);
	}

	@Override
	public HashMap<String, List<Devices>> devicelist(String username) {
		HashMap<String, List<Devices>> devicelist = new HashMap<String, List<Devices>>();
		devicelist.put(username, udo.dlist(username));
		return devicelist;
	}

	@Override
	public String updatepassword(Changepassword users) {

		return udo.updatepassword(users);
	}

	/*
	 * @Override public String changepassword(String uname) {
	 * 
	 * return udo.changepassword(uname); }
	 */
}
