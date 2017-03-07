package com.gps21.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.Services.UserService;
import com.gps21.dao.Userdao;
import com.gps21.model.Device;
import com.gps21.model.Positions;
import com.gps21.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private Userdao udo;

	@Override
	@Transactional
	public List<Positions> plist() {
		return udo.plist();
	}

	@Override
	public List<User> ulList() {
		return udo.ulist();
	}

	@Override
	public User userauthentication(String login, String password) {

		return udo.userauthentication(login, password);
	}

	@Override
	public ArrayList<Device> dlist(String uname) {
		
		return (ArrayList<Device>) udo.dlist(uname);
	}

}
